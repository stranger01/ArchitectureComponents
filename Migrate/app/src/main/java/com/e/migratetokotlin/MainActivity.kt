package com.e.migratetokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val  SELECT_IMAGE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  selectImageButton = findViewById<Button>(R.id.Select)
        val uploadImageButton = findViewById<Button>(R.id.Upload)

        selectImageButton.setOnClickListener {
            pickImage()

        }

        uploadImageButton.setOnClickListener {
            ListImages()
        }
    }

    private fun ListImages() {
        val intent = Intent(baseContext, ListImagesActivity::class.java)
        startActivity(intent)

    }

    fun pickImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE)
    }
}