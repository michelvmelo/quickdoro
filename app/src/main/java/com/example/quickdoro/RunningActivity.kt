package com.example.quickdoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import java.util.Locale

class RunningActivity : AppCompatActivity() {

    private lateinit var studyTimer: CountDownTimer
    private lateinit var breakTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running)

        val studyMin = intent.getIntExtra("study_min", 0)
        val breakMin = intent.getIntExtra("break_min", 0)

        val textHype = findViewById<TextView>(R.id.tv_hype)
        val textClock = findViewById<TextView>(R.id.tv_clock)

        //Countdown timer for study time
        studyTimer = object : CountDownTimer(studyMin.toLong() * 60 * 1000 + 1000, 1000) {
            override fun onTick(left: Long) {
                val mins = (left / 1000) / 60
                val secs = (left / 1000) % 60
                textClock.text = String.format(Locale.getDefault(), "%02d:%02d", mins, secs)
            }
            //Plays sound and switches to break timer
            override fun onFinish() {
                textHype.text = getText(R.string.relax)
                breakTimer.start()
            }
        }.start()

        //Countdown timer for break time
        breakTimer = object : CountDownTimer(breakMin.toLong() * 60 * 1000 + 1000, 1000) {
            override fun onTick(left: Long) {
                val mins = (left / 1000) / 60
                val secs = (left / 1000) % 60
                textClock.text = String.format(Locale.getDefault(), "%02d:%02d", mins, secs)
            }
            //Plays sound and switches to study timer
            override fun onFinish() {
                textHype.text = getText(R.string.focus)
                studyTimer.start()
            }
        }

        //Button to finish 'Running' activity
        val stopButton = findViewById<Button>(R.id.bt_stop)
        stopButton.setOnClickListener {
            finish()
        }

        //Button to switch to 'To-Do' activity
        val todoButton = findViewById<Button>(R.id.bt_todo_running)
        todoButton.setOnClickListener{
            val intentTodoActivity = Intent(this, ToDoActivity::class.java)
            startActivity(intentTodoActivity)
        }
    }
}