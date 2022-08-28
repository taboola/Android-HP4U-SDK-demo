package com.taboola.hp4udemoapplication.viewmodel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.hp4udemoapplication.HP4UDemoConstants
import com.taboola.hp4udemoapplication.event.HP4UDemoUsageEvent
import com.taboola.hp4udemoapplication.R

class SharedViewModel : ViewModel() {

    private var publisherName: String = ""
    private var apiKey: String = ""
    private var wasUsageEventFired = false

    init {
        Taboola.init(
            TBLPublisherInfo(HP4UDemoConstants.DEFAULT_PUBLISHER_NAME).setApiKey(
                HP4UDemoConstants.DEFAULT_API_KEY
            )
        )
    }

    fun setUserInput(editTextId: Int, input: String) {
        when (editTextId) {
            R.id.publisher_et -> publisherName = input
            R.id.api_key_et -> apiKey = input
        }
    }

    fun isAllInputValid(): Boolean {
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
        fragmentActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentToSwitch).addToBackStack(null).commit()
    }

    private fun createDataMapForEvent(eventKey : String, eventValue : String): HashMap<String, String> {
        val data: HashMap<String, String> = HashMap()
        data[eventKey] = eventValue
        return data
    }

    @SuppressLint("RestrictedApi")
    fun reportTaboolaUsageEventPerSession(){
        if(!wasUsageEventFired){
            val dataForUsageEvent : HashMap<String,String> = createDataMapForEvent(HP4UDemoConstants.HP4U_MOBILE_USAGE_EVENT_KEY, HP4UDemoConstants.HP4U_MOBILE_USAGE_EVENT)
            val homePageDemoUsedEvent = HP4UDemoUsageEvent(HP4UDemoConstants.HP4U_MOBILE_USAGE_EVENT, dataForUsageEvent)
            Taboola.getTaboolaImpl().reportTaboolaEvent(null,homePageDemoUsedEvent)
            wasUsageEventFired = true
        }
    }
}