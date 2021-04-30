package com.example.test20210428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_ts1).setOnClickListener {
            val intent = Intent(this,Page2::class.java)   //換頁
            startActivity(intent)
            finish()
        }
    }
}