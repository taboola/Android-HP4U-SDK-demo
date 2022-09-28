package com.taboola.hp4udemoapplication

import android.app.Application
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso

class HP4UApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupPicasso()
    }

    private fun setupPicasso() {
        val maximumMemorySizeForLruCache: Int = Runtime.getRuntime().maxMemory().toInt()
        val picasso: Picasso = Picasso.Builder(this)
            .memoryCache(LruCache(maximumMemorySizeForLruCache))
            .build()
        Picasso.setSingletonInstance(picasso)
    }
}