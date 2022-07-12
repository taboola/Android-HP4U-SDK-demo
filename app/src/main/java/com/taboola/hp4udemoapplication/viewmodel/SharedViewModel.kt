package com.taboola.hp4udemoapplication.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.R

class SharedViewModel : ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = ""
    private var apiKey: String = ""

    init {
        Taboola.init(
            TBLPublisherInfo(HP4UDemoConstants.DEFAULT_PUBLISHER_NAME).setApiKey(
                HP4UDemoConstants.DEFAULT_API_KEY
            )
        )
    }

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

    fun isPreloadChecked() = isPreloadChecked

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment) {
        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }
}