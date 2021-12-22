package com.abdul.synckotlinapp

import android.net.Uri
import android.os.Bundle
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class SmsCPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_cpactivity)

        var cpList: ListView = findViewById(R.id.cpList)
        val uriSms: Uri = Uri.parse("content://sms/inbox")

        var cursor = contentResolver.query(uriSms,null,null,null,null,null)

        var fromColumnsTable = arrayOf("body","address")
        var toTextviews = intArrayOf(android.R.id.text1,android.R.id.text2)
        var layout = android.R.layout.simple_list_item_2

        var adapter:CursorAdapter = SimpleCursorAdapter(this,layout,cursor, fromColumnsTable,toTextviews)

        cpList.adapter = adapter
    }
}