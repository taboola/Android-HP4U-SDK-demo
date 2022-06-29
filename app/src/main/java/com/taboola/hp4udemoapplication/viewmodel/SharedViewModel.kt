package com.taboola.hp4udemoapplication.viewmodel

import MyEvent
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.hp4udemoapplication.R

class SharedViewModel: ViewModel() {

    private var isPreloadChecked: Boolean = false
    private var isLazyLoadChecked: Boolean = false
    private var publisherName: String = "sdk-tester-hp4u-demo"
    private var apiKey: String = "05380b1d71ca985df52d641e1f0336ebbb8d67f7"
    private var isApplicationLive = false
    private var usageEventKey = "MobileEvent"
    private var usageEventValue = "HP4U_ANDROID_USED"

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

    fun getPublisherName() :String{
        return publisherName
    }

    fun getApiKey() :String{
        return apiKey
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

    fun hideToolbar(activity: FragmentActivity) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.hide()
    }

    fun showToolbar(activity: FragmentActivity) {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.show()
    }

    fun switchFragment(fragmentActivity: FragmentActivity, fragmentToSwitch: Fragment){
        fragmentActivity.supportFragmentManager.beginTransaction().replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }

     fun getHP4UEvent(): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map[usageEventKey] = usageEventValue
        return map
    }

    fun reportTaboolaEvent(){
            //We will use this when the user enter the input
            val tblPublisherInfo = TBLPublisherInfo(getPublisherName()).setApiKey(getApiKey())

            // Initialize Taboola SDK as early as possible
            Taboola.init(tblPublisherInfo)

            var customEvent : MyEvent = MyEvent("MobileCustomEvent",getHP4UEvent())

            //Sending an event
            Taboola.reportTaboolaEvent(customEvent.toString(),getHP4UEvent())
    }

    fun reportApplicationIsLive(){

        if(!isApplicationLive){
            reportTaboolaEvent()
            isApplicationLive = true
        }

        else{
        //We already reported.
        }
    }
}