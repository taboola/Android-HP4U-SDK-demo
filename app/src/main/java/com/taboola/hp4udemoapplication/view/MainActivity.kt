package com.taboola.hp4udemoapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso
import com.taboola.hp4udemoapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        val mem: Int = Runtime.getRuntime().maxMemory().toInt()
        picasso = Picasso.Builder(applicationContext)
            .memoryCache(LruCache(mem))
            .build()
        Picasso.setSingletonInstance(picasso)

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsScreenFragment()).commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}