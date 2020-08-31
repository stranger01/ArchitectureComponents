package e.temperat

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApi {
    @GET("http://api.openweathermap.org/")
    fun getForecast(): Call<List<Forecast>>
}

class Forecast(val high: String, val low: String)