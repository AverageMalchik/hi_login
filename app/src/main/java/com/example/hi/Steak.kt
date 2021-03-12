package com.example.hi

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*

class Steak : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_steak)

        /*window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()*/

        //Hiding Navigation Bar
        var obj1:View=findViewById(R.id.layout)
        obj1.systemUiVisibility=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        var obj2:View=findViewById(R.id.layout)
        obj2.systemUiVisibility=View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        var obj3:View=findViewById(R.id.layout)
        obj3.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN

        //Sound
        var cinematic: MediaPlayer?=null
        cinematic= MediaPlayer.create(this,R.raw.cinematic)
        cinematic?.start()

        //1 colour change
        var tv:TextView=findViewById(R.id.fade_tv)
        Handler(Looper.getMainLooper()).postDelayed({
            tv.setTextColor(Color.parseColor("#fc0000"))
        },4000)
    }
}


