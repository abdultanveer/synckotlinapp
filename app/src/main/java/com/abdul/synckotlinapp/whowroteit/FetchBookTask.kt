package com.abdul.synckotlinapp.whowroteit

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView

class FetchBookTask(mTitleText: TextView, mAuthorText: TextView)
                                : AsyncTask<String,Void,String>() {
    var TAG =FetchBookTask::class.java.simpleName

    //https://www.googleapis.com/books/v1/volumes?q=othello&maxResults=10&printType=books
    override fun doInBackground(vararg bookName: String?): String {
        Log.i(TAG,"search for the book named ---"+bookName[0].toString())
        //it has to return the json string
        return NetworkUtils.getBookInfo(bookName[0].toString())
    }

    override fun onPostExecute(jsonString: String?) {
        super.onPostExecute(jsonString)
        Log.i(TAG,"result is \n"+jsonString)
    }

}