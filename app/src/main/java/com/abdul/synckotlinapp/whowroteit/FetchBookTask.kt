package com.abdul.synckotlinapp.whowroteit

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import org.json.JSONObject

class FetchBookTask(var mTitleText: TextView, var mAuthorText: TextView)
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
        parseJson(jsonString);
    }

    private fun parseJson(jsonString: String?) {
        val rootJsonObject = JSONObject(jsonString)
        val itemsArray = rootJsonObject.getJSONArray("items")

        for (i in 0 until itemsArray.length()) {
            val book = itemsArray.getJSONObject(i)
            val title: String? = null
            val authors: String? = null
            val volumeInfo = book.getJSONObject("volumeInfo")

            try {
                var title = volumeInfo.getString("title");
                var authors = volumeInfo.getString("authors");
            } catch (e: Exception) {
                e.printStackTrace();
            }

            if (title != null && authors != null) {
                mTitleText.setText(title);
                mAuthorText.setText(authors);
                return;
            }

            mTitleText.setText("No Results Found");

        }    }

}