package com.e.pluralsight_kotlin

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        val adapterCourses = ArrayAdapter<CourseInfo>(
            applicationContext,
            android.R.layout.simple_list_item_1,
            DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCourses.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)
        if (notePosition != POSITION_NOT_SET)
            displayNote()

    }

    private fun displayNote() {
        val note = DataManager.notes[notePosition]
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        spinnerCourses.setSelection(coursePosition)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}