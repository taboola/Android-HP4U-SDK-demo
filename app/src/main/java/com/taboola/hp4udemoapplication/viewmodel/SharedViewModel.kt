package com.taboola.hp4udemoapplication.viewmodel

import android.annotation.SuppressLint
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.taboola.android.Taboola
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.HP4UDemoUsageEvent
import com.taboola.hp4udemoapplication.R

class SharedViewModel: ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = ""
    private var apiKey: String = ""
    private var isApplicationLive = false

    fun setSwitchCheckedStatus(switchId: Int, checkedState: Boolean) {
        when(switchId) {
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
        when(editTextId) {
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

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment){
        fragmentActivity.supportFragmentManager.beginTransaction().replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }

    private fun createDataMapForEvent(eventKey : String, eventValue : String): Map<String, String> {
        val data: MutableMap<String, String> = HashMap()
        data[eventKey] = eventValue
        return data
    }

    @SuppressLint("RestrictedApi")
    fun reportTaboolaUsageEventPerSession(){

        if(!isApplicationLive){
            val homePageDemoUsedEvent = HP4UDemoUsageEvent(HP4UDemoConstants.usageEventValue,createDataMapForEvent(HP4UDemoConstants.usageEventKey,HP4UDemoConstants.usageEventValue))
            Taboola.getTaboolaImpl().reportTaboolaEvent(null,homePageDemoUsedEvent)
            isApplicationLive = true
        }
    }
}