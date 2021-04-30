package com.example.test20210428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        val pba1 = findViewById<TextView>(R.id.tv_ans1)
        val pba2 = findViewById<TextView>(R.id.tv_ans2)
        val uns1 = findViewById<TextView>(R.id.tv_uans1)
        val uns2 = findViewById<TextView>(R.id.tv_uans2)
        val sc2 = findViewById<TextView>(R.id.tv_sc)
        val btn2 = findViewById<Button>(R.id.btn_nt)
        val pa1 = intent.getBundleExtra("key1")?.getString("pba1")
        val pa2 = intent.getBundleExtra("key1")?.getString("pba2")
        val as1 = intent.getBundleExtra("key1")?.getString("ans1")
        val as2 = intent.getBundleExtra("key1")?.getString("ans2")
        val ass1 = as1?.toInt()
        val ass2 = as2?.toInt()
        pba1.text = "Problem1: " + pa1
        pba2.text = "Problem2: " + pa2
        uns1.text = "Your Answer1: " + as1
        uns2.text = "Your Answer2: " + as2

        if(ass1 == 3 && ass2 == 2){
            sc2.text = "Score: 100"
        }
        else if(ass1 != 3 && ass2 == 2){
            sc2.text = "Score: 50"
        }
        else if(ass1 == 3 && ass2 != 2){
            sc2.text = "Score: 50"
        }
        else sc2.text = "Score: 0"

        findViewById<Button>(R.id.btn_ts2).setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn2.setOnClickListener {
            val intent = Intent(this,Fruit::class.java)
            startActivity(intent)
            finish()
        }
    }
}