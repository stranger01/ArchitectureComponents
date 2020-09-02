package e.temperat

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        val callback = object : Callback<List<Weather>> {
            override fun onResponse(
                call: Call<List<Weather>>,
                response: Response<List<Weather>>
            ) {
                title = response?.body()?.toString()
                Toast.makeText(applicationContext, "Suceed:${response?.body()}", Toast.LENGTH_SHORT)
                    .show()

            }

            override fun onFailure(call: Call<List<Weather>>, t: Throwable) {

                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }

        }

        retriever.getForecast(callback)

    }
}



















