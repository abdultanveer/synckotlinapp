package com.abdul.synckotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class HomeActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        progressBar = findViewById(R.id.progressBar)
    }

    fun clickHandler(view: android.view.View) {
        //start a background thread to download
        var downloadTask = DownloadTask(progressBar);
        downloadTask.execute("https://urlImage.com");

    }
}