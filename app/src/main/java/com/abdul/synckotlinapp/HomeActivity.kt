package com.abdul.synckotlinapp

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class HomeActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var smsReceiver:BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        progressBar = findViewById(R.id.progressBar)
        var intent = Intent("journey planned")
        intent.putExtra("dateoftravel","12345678")
        sendBroadcast(intent,"android.permission.RECEIVE_JOURNEY")

         smsReceiver = SmsReceiver()
        var intentFilter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        registerReceiver(smsReceiver, intentFilter) //dynamic regn
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(smsReceiver)
    }

    fun clickHandler(view: android.view.View) {
        //start a background thread to download
        var downloadTask = DownloadTask(progressBar);
        downloadTask.execute("https://urlImage.com");

    }
}