package com.abdul.synckotlinapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.*

class MyService : Service() {
    var TAG = MyService::class.java.simpleName

    private val cricScore = Random()

    val randomNumber: Int
    get() = cricScore.nextInt(100)



    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "oncreate-myservice")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onstartcommand-myservice")
        var songname = intent?.getStringExtra("songname")
        Log.i(TAG, "i am playing--" + songname)
        /*var  mplayer = MediaPlayer.create(this,R.raw.music)
        mplayer.start()*/


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "ondestroy-myservice")

    }

    fun add(fno:Int, sno:Int):Int {
        return fno + sno
    }

    private val binder = LocalBinder() //binder is like a pipe between service and the activity

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    inner class LocalBinder : Binder() {

        fun getService(): MyService = this@MyService

    }
}