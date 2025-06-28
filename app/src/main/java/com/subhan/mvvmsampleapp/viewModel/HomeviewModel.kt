package com.subhan.mvvmsampleapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhan.mvvmsampleapp.model.Repository
import com.subhan.mvvmsampleapp.model.WeatherData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var Repository: Repository = Repository()

    private val _tempData = MutableLiveData<WeatherData?>()
    val tempData: MutableLiveData<WeatherData?> = _tempData


    fun getTemp(cityName: String) {
        viewModelScope.launch {
            val tempData = Repository.getWeatherData(cityName)
            _tempData.postValue(tempData)
        }
    }
}