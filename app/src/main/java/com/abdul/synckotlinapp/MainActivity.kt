package com.abdul.synckotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var emailEt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailEt = findViewById(R.id.etEmail)
    }

    fun handleClick(view: android.view.View) {
        var email  = emailEt.text.toString()
        Toast.makeText(this,email,Toast.LENGTH_SHORT).show()
        var hIntent = Intent(this,HomeActivity::class.java)
        startActivity(hIntent)
    }
}