package com.example.quizapp.ui

data class Question(
    val id: Int,
    val image: Int,
    val question: String,
    val optOne: String,
    val optTwo: String,
    val optThree: String,
    val optFour: String,
    val correctAnswer: Int,
)
