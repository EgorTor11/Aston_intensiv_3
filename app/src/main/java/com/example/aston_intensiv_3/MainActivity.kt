package com.example.aston_intensiv_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensiv_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindndig: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindndig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindndig.root)
        bindndig.button.setOnClickListener{
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
}