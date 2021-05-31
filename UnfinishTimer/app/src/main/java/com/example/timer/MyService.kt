package com.example.timer

import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.IBinder
import android.widget.Chronometer

class MyService : Service() {

    private var iBinder:IBinder?=null
    private lateinit var stp:Chronometer

    override fun onBind(intent: Intent): IBinder? {
        return iBinder
    }

    override fun onCreate() {
        super<Service>.onCreate()
    }

}