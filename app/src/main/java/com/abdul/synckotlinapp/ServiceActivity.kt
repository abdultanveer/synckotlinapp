package com.abdul.synckotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }

    fun handleService(view: android.view.View) {
        when(view.id){
            R.id.btnStart -> { startMyService()}
            R.id.btnStop -> {stopMyService()}
        }
    }

    private fun stopMyService() {
        var intent = Intent(this,MyService::class.java)
        stopService(intent)
    }

    private fun startMyService() {
        var intent = Intent(this,MyService::class.java)
        startService(intent)
        }
}