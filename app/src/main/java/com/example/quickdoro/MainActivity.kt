package com.example.quickdoro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Creates a blinking animation for 'tv_click' TextView
        val tvClick = findViewById<View>(R.id.tv_click) as TextView

        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 1000
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        tvClick.startAnimation(anim)

        //Creates a click event to switch to 'ClockActivity' activity
        val mainLayout = findViewById<ConstraintLayout>(R.id.main_layout)
        mainLayout.setOnClickListener{
            val intentClockActivity = Intent(this, ClockActivity::class.java)
            startActivity(intentClockActivity)
        }
    }
}