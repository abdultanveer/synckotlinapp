package com.abdul.synckotlinapp.whowroteit

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView

class FetchBookTask(mTitleText: TextView, mAuthorText: TextView)
                                : AsyncTask<String,Void,String>() {
    var TAG =FetchBookTask::class.java.simpleName

    override fun doInBackground(vararg bookName: String?): String {
        Log.i(TAG,"search for the book named ---"+bookName[0].toString())
        //it has to return the json string
        return ""
    }

}