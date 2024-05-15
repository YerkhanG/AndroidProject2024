package com.example.androidproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidproject.databinding.ActivityLoginBinding
import com.example.androidproject.util.UserData


class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        with(binding) {
            binding.submit.setOnClickListener {
                val login = loginEt.text.toString()
                val password = loginEt.text.toString()
                UserData(applicationContext).setAuthorized()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun setup() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}