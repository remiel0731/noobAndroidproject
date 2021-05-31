package com.example.timer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var strbtn: FloatingActionButton
    private lateinit var stpbtn: FloatingActionButton
    private lateinit var pasbtn: FloatingActionButton
    private lateinit var stpwatch: Chronometer
    private  var pauseAt: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        strbtn = findViewById(R.id.btn_str)
        pasbtn = findViewById(R.id.btn_pas)
        stpbtn = findViewById(R.id.btn_re)
        stpwatch = findViewById(R.id.tv_time)

        strbtn.setOnClickListener(this)
        stpbtn.setOnClickListener(this)
        pasbtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == strbtn) {
            sendBroadcast(Intent("Start"))
            stpwatch.base = SystemClock.elapsedRealtime() - pauseAt //6000
            stpwatch.start()
        } else if (v == pasbtn) {
            pauseAt = SystemClock.elapsedRealtime() - stpwatch.base //10000-6000=4000
            stpwatch.stop()
        } else {
            stpwatch.base=SystemClock.elapsedRealtime()
        }
    }
}