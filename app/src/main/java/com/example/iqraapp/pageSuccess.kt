package com.example.iqraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pageSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lateinit var btngo_back: Button
        setContentView(R.layout.activity_page_success)
        btngo_back= findViewById(R.id.btngo_back)
        btngo_back.setOnClickListener{
            val intent = Intent(this, pageLogin::class.java)
            startActivity(intent)
        }
    }
}