package co.coolresume

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myProjects = findViewById<Button>(R.id.myProjectsBtn)

        myProjects.setOnClickListener {
            val intent = Intent(this, MyProjects::class.java)
            startActivity(intent)

        }

        val callMe = findViewById<Button>(R.id.callMeBtn)


        callMe.setOnClickListener {

            val phone = Uri.parse("tel:3213090201")
            val callME = Intent(Intent.ACTION_DIAL, phone)
            startActivity(callME)

        }

        val emailMe = findViewById<Button>(R.id.emailBtn)

        emailMe.setOnClickListener {

            val email = Intent(Intent.ACTION_SEND)
            email.type = "plain/text"
            email.putExtra(Intent.EXTRA_EMAIL, "joseantoniosysnet@gmail.com")
            startActivity(email)

        }
    }
}