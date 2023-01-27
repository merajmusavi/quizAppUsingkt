package com.example.quizappusingkt

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizappusingkt.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding
    private val current_q = 0

    private lateinit var questions: ArrayList<DataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questions = Constant.createObj() as ArrayList<DataModel>

        val question = questions[current_q]
        dataset(question)

    }


    fun reset_to_defualt(){
      var textview_array = ArrayList<TextView>()
        textview_array.add(binding.option1)
        textview_array.add(binding.option2)
        textview_array.add(binding.option3)
        textview_array.add(binding.option4)

        for (textView in textview_array) {
            textView.typeface = Typeface.DEFAULT
            textView.background = ContextCompat.getDrawable(this,R.drawable.bg_option)
        }
    }

    fun dataset(question: DataModel) {
        binding.tvQuestion.text = question.question
        binding.option1.text = question.option1
        binding.option2.text = question.option2
        binding.option3.text = question.option3
        binding.option4.text = question.option4
        binding.tvFlag.setImageResource(question.image)
    }

    fun OnOptionClicked(view:View){
        reset_to_defualt()

        val btn = view as TextView
        btn.typeface = Typeface.DEFAULT_BOLD
        btn.background = ContextCompat.getDrawable(this,R.drawable.bg_option_after_selection)
    }
}