package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            val etName: EditText = findViewById(R.id.et_name)
            if (etName.text.isNotEmpty())
                startActivity(Intent(this, QuestionsActivity::class.java)
                    .apply { this.putExtra("USERNAME", etName.text.toString()) })
            else
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
        }
    }
}