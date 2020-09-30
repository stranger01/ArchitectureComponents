package com.e.pluralsight_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            val intent = Intent(applicationContext, NoteActivity::class.java)
            startActivity(intent)
        }


        listItems.layoutManager = LinearLayoutManager(applicationContext)
        listItems.adapter = NoteRecyclerAdapter(applicationContext, DataManager.notes)

    }

    override fun onResume() {
        super.onResume()

        listItems.adapter?.notifyDataSetChanged()
    }

}

















