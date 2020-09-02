package e.temperat

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApi {
    @GET("?location=sunnyvale,ca&format=json")
    fun getForecast(): Call<List<Weather>>
}

class Weather(var location : WeatherQuery)
class WeatherQuery(val results : WeatherResults)
class WeatherResults(val channel : WeatherChannel)
class WeatherChannel(val title : String)

class WeatherRetriever {
    val service: WeatherApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://weather-ydn-yql.media.yahoo.com/forecastrss/")
            .addConverterFactory(GsonConverterFactory.create()).build()
       service = retrofit.create(WeatherApi::class.java)
    }

    fun getForecast(callback : Callback<List<Weather>>){
        val call = service.getForecast()
        call.enqueue(callback)
    }
}