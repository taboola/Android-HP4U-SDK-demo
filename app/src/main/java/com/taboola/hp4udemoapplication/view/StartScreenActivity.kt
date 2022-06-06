package com.taboola.hp4udemoapplication.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.taboola.hp4udemoapplication.R


class StartScreenActivity : AppCompatActivity() {

    private val splashTimeout: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed(Runnable {
            val intent: Intent = Intent(this@StartScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeout)
    }
}