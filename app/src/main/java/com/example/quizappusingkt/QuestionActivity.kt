package com.example.quizappusingkt

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizappusingkt.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding
    private var current_q = 0
    private var which_option = 0
    private lateinit var questions: ArrayList<DataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questions = Constant.createObj() as ArrayList<DataModel>

        dataset()


    }


    fun reset_to_defualt() {
        var textview_array = ArrayList<TextView>()
        textview_array.add(binding.option1)
        textview_array.add(binding.option2)
        textview_array.add(binding.option3)
        textview_array.add(binding.option4)

        for (textView in textview_array) {
            textView.typeface = Typeface.DEFAULT
            textView.background = ContextCompat.getDrawable(this, R.drawable.bg_option)
        }
    }

    fun dataset() {
        val question = questions[current_q]
        binding.tvQuestion.text = question.question
        binding.option1.text = question.option1
        binding.option2.text = question.option2
        binding.option3.text = question.option3
        binding.option4.text = question.option4
        binding.tvFlag.setImageResource(question.image)
    }

    fun OnOptionClicked(view: View) {
        reset_to_defualt()

        val btn = view as TextView
        when (btn.tag.toString()) {
            "1" -> {
                which_option = 1
            }
            "2" -> {
                which_option = 2
            }
            "3" -> {
                which_option = 3
            }
            "4" -> {
                which_option = 4
            }
        }
        btn.typeface = Typeface.DEFAULT_BOLD
        btn.background = ContextCompat.getDrawable(this, R.drawable.bg_option_after_selection)
    }

    fun onSubmitClicked(view: View) {
        if (which_option == 0 && current_q <= 2) {
            current_q++

            dataset()

        } else {
            if (which_option == questions[current_q].correct) {
                setBgForTv(questions[current_q].correct,R.drawable.bg_option_true)


            } else {
                setBgForTv(which_option, R.drawable.bg_option_false)
                setBgForTv(questions[current_q].correct,R.drawable.bg_option_true)

            }

        }
    }

    fun setBgForTv(id: Int, draw: Int) {
        when (id) {
            1 -> {
                binding.option1.background = ContextCompat.getDrawable(this, draw)
            }
            2 -> {
                binding.option2.background = ContextCompat.getDrawable(this, draw)
            }
            3 -> {
                binding.option3.background = ContextCompat.getDrawable(this, draw)

            }
            4 -> {
                binding.option4.background = ContextCompat.getDrawable(this, draw)

            }
        }
    }
}