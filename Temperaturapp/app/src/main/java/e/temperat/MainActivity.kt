package e.temperat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lookCity = findViewById<Button>(R.id.lookCityBtn)

        lookCity.setOnClickListener {
            val intent = Intent(this, ListWeather::class.java)
            startActivity(intent)
        }
    }
}