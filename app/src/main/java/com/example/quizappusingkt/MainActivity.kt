package com.example.quizappusingkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.quizappusingkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnLogin.setOnClickListener {
            if (bind.etUserName.text.toString().isEmpty()){
                bind.layoutEt.error = "enter your name"
                Toast.makeText(this,"enter your name",Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this,QuestionActivity::class.java)
                startActivity(intent)
            }
        }

    }
}