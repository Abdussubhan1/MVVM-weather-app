package com.subhan.mvvmsampleapp.NetworkLayer


import com.subhan.mvvmsampleapp.Model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("/data/2.5/weather")
    suspend fun enterCity(
        @Query("q") cityName: String,
        @Query("appid") apikey: String = "729664ac11fd795189d8bbdd096156f3"
    ): Response<WeatherResponse>

}