package com.example.quickdoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker

class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        //Sets max and min values for the number pickers
        val npMinEstudo = findViewById<NumberPicker>(R.id.np_min_study)
        val npMinInt = findViewById<NumberPicker>(R.id.np_min_break)

        npMinEstudo.minValue = 0
        npMinEstudo.maxValue = 60
        npMinInt.minValue = 0
        npMinInt.maxValue = 60

    }
}