package com.example.quizapp.ui

import com.example.quizapp.R

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val stdQuestion = "What country does this flag belong to?"

        questionsList.add(
            Question(
                0, R.drawable.ic_flag_of_argentina, stdQuestion,
                "Argentina", "Armenia",
                "Azerbaijan", "North Macedonia", 0
            )
        )

        questionsList.add(
            Question(
                1, R.drawable.ic_flag_of_australia, stdQuestion,
                "Angola", "Austria",
                "Australia", "Armenia", 2
            )
        )

        questionsList.add(
            Question(
                2, R.drawable.ic_flag_of_brazil, stdQuestion,
                "Belarus", "Belize",
                "Brazil", "Brunei", 2
            )
        )

        questionsList.add(
            Question(
                3, R.drawable.ic_flag_of_belgium, stdQuestion,
                "Bahamas", "Belgium",
                "Belize", "Barbados", 1
            )
        )

        questionsList.add(
            Question(
                4, R.drawable.ic_flag_of_fiji, stdQuestion,
                "Gabon", "France",
                "Fiji", "Finland", 2
            )
        )

        questionsList.add(
            Question(
                5, R.drawable.ic_flag_of_germany, stdQuestion,
                "Germany", "Georgia",
                "Greece", "Russia", 0
            )
        )

        questionsList.add(
            Question(
                6, R.drawable.ic_flag_of_denmark, stdQuestion,
                "Dominica", "Denmark",
                "Egypt", "Ethiopia", 1
            )
        )

        questionsList.add(
            Question(
                7, R.drawable.ic_flag_of_india, stdQuestion,
                "Ireland", "Iran",
                "Hungary", "India", 3
            )
        )

        questionsList.add(
            Question(
                8, R.drawable.ic_flag_of_new_zealand, stdQuestion,
                "Australia", "New Zeland",
                "Tuvalu", "USA", 1
            )
        )

        questionsList.add(
            Question(
                9, R.drawable.ic_flag_of_kuwait, stdQuestion,
                "Jordan", "Kuwait",
                "Iran", "Palestine", 1
            )
        )

        return questionsList
    }
}