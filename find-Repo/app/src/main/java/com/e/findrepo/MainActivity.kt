package com.e.findrepo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.findRepoBtn)
        val text = findViewById<EditText>(R.id.searchRepoTxt)

        button.setOnClickListener {
            val intent = Intent(applicationContext, DisplayRepoActivity::class.java)
            intent.putExtra("searchTerm", text.text.toString())
            startActivity(intent)

        }
    }
}