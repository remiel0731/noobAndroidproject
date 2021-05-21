package com.example.servicetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var startBtn:Button
    lateinit var stopBtn:Button
    lateinit var musicImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn=findViewById(R.id.btn_str)
        stopBtn=findViewById(R.id.btn_stp)
        musicImage=findViewById(R.id.musicImage)

        stopBtn.setOnClickListener (this)
        startBtn.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        if(v==startBtn){
            musicImage.visibility=View.VISIBLE
            startService(Intent(this,MyService::class.java))
        }
        else{
            musicImage.visibility=View.GONE
            stopService(Intent(this,MyService::class.java))
        }
    }
}