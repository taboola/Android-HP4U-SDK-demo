package com.taboola.hp4udemoapplication.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.android.homepage.TBLHomePage
import com.taboola.android.listeners.TBLHomePageListener
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.SingleLiveEvent
import com.taboola.hp4udemoapplication.view.HomePageScreenFragment

class SharedViewModel : ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = ""
    private var apiKey: String = ""
    private var homePage: TBLHomePage? = null
    private var itemClicked = SingleLiveEvent<String?>()

    init {
        Taboola.init(
            TBLPublisherInfo(HP4UDemoConstants.DEFAULT_PUBLISHER_NAME).setApiKey(
                HP4UDemoConstants.DEFAULT_API_KEY
            )
        )
        homePage = Taboola.getHomePage(
            "home", "https://www.sdktesterhp4udemo.com",
            object : TBLHomePageListener() {

                override fun onHomePageError(error: String?, sectionName: String?) {
                    super.onHomePageError(error, sectionName)
                    Log.d("SLAVA", error + "")
                }

                override fun onHomePageItemClick(
                    sectionName: String?,
                    itemId: String?,
                    clickUrl: String?,
                    isOrganic: Boolean,
                    customData: String?
                ): Boolean {
                    itemClicked.value = clickUrl
                    return false
                }
            }, "sport", "technology", "topnews"
        )
    }

    fun itemClicked(): LiveData<String?> = itemClicked

    fun getHomePage(): TBLHomePage? = homePage

    fun setSwitchCheckedStatus(switchId: Int, checkedState: Boolean) {
        when (switchId) {
            R.id.preload_switch -> {
                isPreloadChecked = checkedState
                isLazyLoadChecked = !checkedState
            }
            R.id.lazy_load_switch -> {
                isLazyLoadChecked = checkedState
                isPreloadChecked = !checkedState
            }
        }
    }

    fun setUserInput(editTextId: Int, input: String) {
        when (editTextId) {
            R.id.publisher_et -> publisherName = input
            R.id.api_key_et -> apiKey = input
        }
    }

    fun isAllInputValid(): Boolean {
        //One switch must be checked
        if (!isPreloadChecked && !isLazyLoadChecked) {
            return false
        }

        if (publisherName.isEmpty() || apiKey.isEmpty()) {
            return false
        }
        return true
    }

    fun setToolbarTitle(activity: FragmentActivity, toolbarTitle: String) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title = toolbarTitle
    }

    fun setToolbarTitleTextAppearance(toolbar: Toolbar, resId: Int) {
        toolbar.setTitleTextAppearance(toolbar.context, resId)
    }

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment) {
        if (fragmentToSwitch is HomePageScreenFragment && isPreloadChecked) {
            homePage?.fetchContent()
        }
        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }

    fun setupHomePage(homepageRecyclerview: RecyclerView) {
        homePage?.attach(homepageRecyclerview)
    }
}