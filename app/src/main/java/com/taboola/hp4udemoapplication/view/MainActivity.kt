package com.taboola.hp4udemoapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taboola.hp4udemoapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsScreenFragment()).commit()
        }
    }
}