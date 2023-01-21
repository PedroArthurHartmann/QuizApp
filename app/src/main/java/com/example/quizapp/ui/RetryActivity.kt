package com.example.quizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R

class RetryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retry)

        val score = intent.getShortExtra("SCORE", -1)

        findViewById<TextView>(R.id.tv_name).text = intent.getStringExtra("USERNAME")
        findViewById<TextView>(R.id.tv_score).text = "Your Score is $score out of 10"

        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            finish()
        }
    }
}