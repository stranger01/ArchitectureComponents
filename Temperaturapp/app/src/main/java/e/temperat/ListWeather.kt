package e.temperat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListWeather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_weather)

        val listView = findViewById<ListView>(R.id.foreCastListView)

        val artistas = listOf(
            "Romeo Santos",
            "Hot Chili",
            "Jaguares",
            "Caifanes",
            "Cafe tacuba",
            "Mana",
            "Farruko",
            "Don omar",
            "Los toros van",
            "Ozone",
            "Marylin Manson",
            "Audioslave",
            "Linkin Park"
        )

        val adapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, artistas)
        listView.adapter = adapter


        var retriever = WeatherRetriever()

        val callback = object : Callback<List<Query>> {
            override fun onResponse(
                call: Call<List<Query>>,
                response: Response<List<Query>>
            ) {
                Toast.makeText(applicationContext,"Suceed:",Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<List<Query>>, t: Throwable) {

                Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
            }

        }

        retriever.getForecast(callback)

    }
}



















