package com.example.hwapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_send.setOnClickListener {
            if(radioButton.isChecked){
                if(radioButton5.isChecked)
                    tv_view.text = "無糖 去冰"
                else if(radioButton6.isChecked)
                    tv_view.text = "無糖 微冰"
                else if(radioButton7.isChecked)
                    tv_view.text = "無糖 少冰"
                else tv_view.text = "無糖 正常冰"
            }
            else if(radioButton2.isChecked){
                if(radioButton5.isChecked)
                    tv_view.text = "微糖 去冰"
                else if(radioButton6.isChecked)
                    tv_view.text = "微糖 微冰"
                else if(radioButton7.isChecked)
                    tv_view.text = "微糖 少冰"
                else tv_view.text = "微糖 正常冰"
            }
            else if(radioButton3.isChecked){
                if(radioButton5.isChecked)
                    tv_view.text = "半糖 去冰"
                else if(radioButton6.isChecked)
                    tv_view.text = "半糖 微冰"
                else if(radioButton7.isChecked)
                    tv_view.text = "半糖 少冰"
                else tv_view.text = "半糖 正常冰"
            }
            else {
                if(radioButton5.isChecked)
                    tv_view.text = "全糖 去冰"
                else if(radioButton6.isChecked)
                    tv_view.text = "全糖 微冰"
                else if(radioButton7.isChecked)
                    tv_view.text = "全糖 少冰"
                else tv_view.text = "全糖 正常冰"
            }
        }
    }
}