package com.abdul.synckotlinapp;

import android.os.AsyncTask;
import android.util.Log;

public class DownloadTask extends AsyncTask<String,Integer,Void> {

    public static  String TAG = DownloadTask.class.getSimpleName();
    /**
     * this doinbackground method works in the background thread
     * @param
     * @return
     */
    @Override
    protected Void doInBackground(String... downloadUrl) {
        Log.i(TAG,downloadUrl[0]);
        for(int i=1; i<21;  i+=5){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
