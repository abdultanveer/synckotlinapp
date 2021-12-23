package com.abdul.synckotlinapp

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder

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
        intent.putExtra("songname","rafisong.mp3")
        startService(intent)
        }

    fun handleBinding(view: android.view.View) {
        var intent = Intent(this,MyService::class.java)
        bindService(intent,connection, BIND_AUTO_CREATE)
    }

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance

        }

        override fun onServiceDisconnected(arg0: ComponentName) {
        }
    }
}