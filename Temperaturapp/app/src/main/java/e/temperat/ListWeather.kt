package e.temperat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListWeather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_weather)

        val listView = findViewById<ListView>(R.id.foreCastListView)

        val artistas = listOf(
            "Romeo Santos", "Hot Chili", "Jaguares", "Caifanes", "Cafe tacuba",
            "Mana", "Farruko", "Don omar", "Los toros van", "Ozone", "Marylin Manson", "Audioslave", "Linkin Park")

        val adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, artistas)
        listView.adapter = adapter

    }
}



















