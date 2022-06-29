package com.taboola.hp4udemoapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.taboola.android.TBLPublisherInfo
import com.taboola.android.Taboola
import com.taboola.android.global_components.eventsmanager.TBLEventType
import com.taboola.android.global_components.eventsmanager.TBLEventsManager
import com.taboola.android.global_components.eventsmanager.events.TBLMobileEvent
import com.taboola.hp4udemoapplication.R
import com.taboola.hp4udemoapplication.model.PublisherInfo
import com.taboola.hp4udemoapplication.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    fun getHP4UEvent(): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map["usageEventKey"] = "usageEventValue"
        return map
    }
}