package com.example.quizappusingkt

import android.provider.ContactsContract.Data

class Constant {
    companion object{
        fun createObj():List<DataModel>{
            var questions = ArrayList<DataModel>()
            val q1 = DataModel("which country is?",1,R.drawable.ic_flag_of_argentina,"iran","argentina","usa","brazil",2)
            val q2 = DataModel("which country is?",1,R.drawable.ic_flag_of_belgium,"iran","argentina","usa","belgium",2)
            val q3 = DataModel("which country is?",1,R.drawable.ic_flag_of_australia,"iran","argentina","australia","brazil",2)
            val q4 = DataModel("which country is?",1,R.drawable.ic_flag_of_germany,"germany","argentina","usa","brazil",2)
            questions.add(q1)
            questions.add(q2)
            questions.add(q3)
            questions.add(q4)
            return questions

        }
    }
}