package com.example.miniact3_c

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val tv = findViewById<TextView>(R.id.textView)
            val data = intent?.extras
            val text = data?.getString(Intent.EXTRA_TEXT)
            tv.text = text
        } catch (e: Exception) {
        }
    }
}