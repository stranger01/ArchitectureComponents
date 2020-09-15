package com.e.findrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DisplayRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_repo)

        val searchTerm = intent.getStringExtra("searchTerm")

        Toast.makeText(applicationContext, "La busqueda es $searchTerm", Toast.LENGTH_SHORT).show()
    }
}