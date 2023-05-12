package com.example.aston_intensiv_3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.aston_intensiv_3.databinding.ActivityMain2Binding
import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                Log.d("myLog", "after  $s")
                Glide.with(this@MainActivity2).load(s.toString().toUri()).into(binding.imageView)
            }
        })
        binding.button2.setOnClickListener {
            var bm: Bitmap?
            Thread {
                bm = getImageBitmap(binding.edSearch.text.toString())
                runOnUiThread {
                    binding.imageView2.setImageBitmap(bm)
                }
            }.start()
        }
    }

    private fun getImageBitmap(url: String): Bitmap? {
        var bm: Bitmap? = null
        try {
            val aURL = URL(url)
            val conn = aURL.openConnection()
            conn.connect()
            val `is` = conn.getInputStream()
            val bis = BufferedInputStream(`is`)
            bm = BitmapFactory.decodeStream(bis)
            bis.close()
            `is`.close()
        } catch (e: IOException) {
            Log.e("TAG", "Error getting bitmap", e)
        }
        return bm
    }
}