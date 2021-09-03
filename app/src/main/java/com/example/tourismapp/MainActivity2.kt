package com.example.tourismapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main2.*

import kotlinx.android.synthetic.main.places.images

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle: Bundle? =intent.extras
        val name=bundle!!.getString("name")
        val info=bundle.getString("info")
        val pic= bundle.getInt("pic")
        images.setImageResource(pic)
        tvName.text=name
        tvDesc.text=info
    }
}