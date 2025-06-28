package com.subhan.mvvmsampleapp.model

import android.content.ContentValues.TAG
import android.util.Log
import com.subhan.mvvmsampleapp.networkLayer.RetrofitInterface
import com.subhan.mvvmsampleapp.networkLayer.ServiceBuilder

class Repository {
    suspend fun getWeatherData(cityName: String): WeatherData? {
        return try {
            val response =
                ServiceBuilder.buildService(RetrofitInterface::class.java).enterCity(cityName)

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val temperature = (body.main.temp)-273
                    return WeatherData(
                        temperature = temperature,description = body.weather[0].description
                    )
                }
            }
            null

        } catch (e: Exception) {
            Log.e(TAG, "validateIgnition error: ${e.message}")
            null
        }
    }
}