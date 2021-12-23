package com.abdul.synckotlinapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

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

    private lateinit var mService: MyService


    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, binder: IBinder) {
               // var myService = MyService() -- creating a service -- setting up a catering service - iam not going to setup
            val binder = binder as MyService.LocalBinder //as = typecasting
            mService = binder.getService()
            var score = mService.randomNumber  //now you can order a lunch to be prepared by the catering service
            var sum = mService.add(12,34)

            Toast.makeText(applicationContext,"score is--"+score+"sum is--"+sum,Toast.LENGTH_SHORT).show()

        }

        override fun onServiceDisconnected(arg0: ComponentName) {
        }
    }

    fun showNotification(view: android.view.View) {
        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_home_black_24dp)
            .setContentTitle("notif title")
            .setContentText("content text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        createNotificationChannel()
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }

    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "promotions channel"
            val descriptionText = "description for promotions channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}