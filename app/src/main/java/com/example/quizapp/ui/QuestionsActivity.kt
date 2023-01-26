package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.quizapp.R
import com.example.quizapp.ui.RetryActivity
import com.example.quizapp.databinding.ActivityQuestionsBinding
import kotlinx.coroutines.delay

class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    private val questions = Constants.getQuestions()
    private var selectedOpt: Int? = null
    private var currQuestionIdx: Int = -1
    private lateinit var arrOptions: Array<Button>
    private var gotCorrectCount: Short = 0
    private var gotCorrect = false
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("USERNAME") ?: ""

        val wrongOptionToast = Toast.makeText(this,"Wrong option",Toast.LENGTH_LONG)

        arrOptions = arrayOf(
            binding.btOptionOne,
            binding.btOptionTwo,
            binding.btOptionThree,
            binding.btOptionFour
        ).apply {
            forEachIndexed { index, button ->
                button.setOnClickListener {
                    selectedOpt = index

                    if (selectedOpt == questions[currQuestionIdx].correctAnswer) {
                        arrOptions[selectedOpt!!].setBackgroundColor(resources.getColor(R.color.green))
                        Thread.sleep(1000)
                        nextQuestion()
                    }
                    else {
                            wrongOptionToast.show()
                            arrOptions[selectedOpt!!].setBackgroundColor(resources.getColor(R.color.red))
                            gotCorrect = false
                    }
                }
            }
        }

        nextQuestion()
    }

    private fun finishThis() {
        startActivity(Intent(this, RetryActivity::class.java).apply {
            this.putExtra("USERNAME", name)
            this.putExtra("SCORE", gotCorrectCount)
        })
        finish()
    }

    private fun nextQuestion() {

        if (gotCorrect)
            gotCorrectCount++

        var currQuestion: Question? = null

        if (currQuestionIdx < questions.size - 1)
            currQuestion = questions[++currQuestionIdx]
        else
            finishThis()

        with(binding) {
            if (currQuestion != null) {
                tvQuestion.text = currQuestion.question
                ivImage.setImageResource(currQuestion.image)
                btOptionOne.text = currQuestion.optOne
                btOptionTwo.text = currQuestion.optTwo
                btOptionThree.text = currQuestion.optThree
                btOptionFour.text = currQuestion.optFour
            }
        }
        gotCorrect = true
        selectedOpt = null
        arrOptions.forEach {
            it.setBackgroundColor(resources.getColor(R.color.gray))
        }
        binding.progressBar.progress = currQuestionIdx
    }
}