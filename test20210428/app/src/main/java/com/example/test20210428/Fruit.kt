package com.example.test20210428

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

//設計新的類別定義水果的資料結構
data class Item(
        val photo: Int, //圖片
        val name: String, //名稱
        val price: Int, //價格
        val price2: String, //單價
        val count1: String, //數量1
        val count2: Int //數量2
)

class Fruit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)
        val lsf = findViewById<ListView>(R.id.lv_fruit)
        val item = ArrayList<Item>() //儲存水果資訊
        val priceRange = IntRange(10, 100) //建立價格範圍
        val ccRange = IntRange(1 , 10)
        val array = resources.obtainTypedArray(R.array.image_list) //從 R 類別讀取圖檔
        val btnhm = findViewById<Button>(R.id.btn_bk)
        for(i in 0 until array.length()) {
            val photo = array.getResourceId(i,0) //水果圖片 Id
            val price = priceRange.random() //亂數產生價格
            val price2 = "單價" //顯示文字"單價"
            val count1 = "購買數量" //顯示文字"數量"
            val count2 = ccRange.random() //亂數產生數量
            var name = ""// 名稱
            if(i == 0){
                name = "蘋果"
            } else if(i == 1){
                name = "香蕉"
            } else if(i == 2){
                name = "櫻桃"
            } else{
                name = "葡萄"
            }
            item.add(Item(photo, name, price, price2, count1, count2 )) //新增水果資訊
        }
        array.recycle() //釋放圖檔資源
        //建立 MyAdapter 物件，並傳入 adapter_horizontal 作為畫面
        lsf.adapter = MyAdapter(this, item, R.layout.adapter_vertical)

        btnhm.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
