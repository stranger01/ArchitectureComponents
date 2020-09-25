package com.e.pluralsight_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        listNotes.adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataManager.notes)

        listNotes.setOnItemClickListener { _, _, position, _ ->
            val activityIntent = Intent(applicationContext, MainActivity::class.java)
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)

        }
    }

}

















