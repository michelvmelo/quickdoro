package com.example.quickdoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker

class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        //Sets max and min values for the number pickers
        val npMinStudy = findViewById<NumberPicker>(R.id.np_min_study)
        val npMinBreak = findViewById<NumberPicker>(R.id.np_min_break)

        npMinStudy.minValue = 0
        npMinStudy.maxValue = 60
        npMinBreak.minValue = 0
        npMinBreak.maxValue = 60

        //Sets button function to switch to 'Running' activity
        val startButton = findViewById<Button>(R.id.bt_start)
        startButton.setOnClickListener{
            val startRunning = Intent(this, RunningActivity::class.java)
            startRunning.putExtra("study_min", npMinStudy.value)
            startRunning.putExtra("break_min", npMinBreak.value)
            startActivity(startRunning)
        }
    }
}