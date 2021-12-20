package com.abdul.synckotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var emailEt : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailEt = findViewById(R.id.etEmail)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.miSettings -> { Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show()}
            R.id.miLogout -> {Toast.makeText(this,"logout",Toast.LENGTH_SHORT).show()}
        }

        return true
    }

    fun handleClick(view: android.view.View) {
        var email  = emailEt.text.toString()
        Toast.makeText(this,email,Toast.LENGTH_SHORT).show()
        var hIntent = Intent(this,HomeActivity::class.java)
        startActivity(hIntent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish();
    }
}