package com.example.test20210428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val sb = findViewById<Button>(R.id.btn_sb)
        val btn = findViewById<Button>(R.id.btn_tas)
        val tt1 = findViewById<TextView>(R.id.tv_tt1)
        val an1 = findViewById<EditText>(R.id.et_a1)
        val an2 = findViewById<EditText>(R.id.et_a2)
        val pa1 = (1+2).toString()
        val pa2 = (1*2).toString()

        sb.setOnClickListener {
            val intent = Intent(this,Page3::class.java) //換頁
            val bundle= Bundle() //打包
            bundle.putString("pba1",pa1)
            bundle.putString("pba2",pa2)
            bundle.putString("ans1",an1.text.toString()) //不可先轉換數字到字串，不然會有問題。
            bundle.putString("ans2",an2.text.toString()) //不可先轉換數字到字串，不然會有問題。
            intent.putExtra("key1",bundle)
            startActivity(intent)
            finish()
        }
        btn.setOnClickListener {
            tt1.text = pa1 + pa2+ an1.text.toString() + an2.text.toString() //驗證輸入資料是否作動
        }
    }
}