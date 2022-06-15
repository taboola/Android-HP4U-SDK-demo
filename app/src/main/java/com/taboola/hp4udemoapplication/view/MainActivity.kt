package com.taboola.hp4udemoapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.android.global_components.eventsmanager.TBLEventType
import com.taboola.android.global_components.eventsmanager.TBLEventsManager
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.model.PublisherInfo
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    var model :SharedViewModel = SharedViewModel()
    var mTBLEventsManager: TBLEventsManager? = null


    @TBLEventType
    private val mEventType: String = TBLEventType.DEFAULT

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //We will use this when the user enter the input
//        val tblPublisherInfo = TBLPublisherInfo(model.getPublisherName()).setApiKey(model.getApiKey())

        //We are using this now just for POC.
        // Define a publisher info object
        val publisherInfo = TBLPublisherInfo(PublisherInfo.PUBLISHER).setApiKey(PublisherInfo.API_KEY)

        // Initialize Taboola SDK as early as possible
        Taboola.init(publisherInfo)

        //Sending an event
        Taboola.reportTaboolaEvent(TBLEventType.DEFAULT,getHP4UEvent())

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsScreenFragment()).commit()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getHP4UEvent(): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map["MobileEvent"] = "HP4U_ANDROID_USED"
        return map
    }
}