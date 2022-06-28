package com.taboola.hp4udemoapplication.viewmodel

import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.android.homepage.TBLHomePage
import com.taboola.android.listeners.TBLHomePageListener
import com.taboola.hp4udemoapplication.R
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = ""
    private var apiKey: String = ""
    private var homePage: TBLHomePage? = null

    init {
        Taboola.init(TBLPublisherInfo("sdk-tester-hp4u-demo").setApiKey("05380b1d71ca985df52d641e1f0336ebbb8d67f7"))
        homePage = Taboola.getHomePage(
            "text", "https://www.sdktesterhp4udemo.com",
            null, "sport", "technology", "topnews"
        )
    }


    public fun getHomePage(): TBLHomePage? = homePage

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

    fun isTextValid(editable: Editable): Boolean {
        val text: String = editable.toString()
        return text.isNotEmpty()
    }

    fun isAllInputValid(): Boolean {
        //One switch must be checked
        return true
        if (!isPreloadChecked && !isLazyLoadChecked) {
            return false
        }

        if (publisherName.isEmpty() || apiKey.isEmpty()) {
            return false
        }
        return true
    }

    fun setToolbarTitle(activity: FragmentActivity, toolbarTitle:String) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.title = toolbarTitle
    }

    fun setToolbarTitleColor(toolbar: Toolbar, color: Int) {
        toolbar.setTitleTextColor(color)
    }

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment) {
        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }
}