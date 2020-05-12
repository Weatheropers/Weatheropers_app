package com.silso.additional_weather_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.silso.additional_weather_app.data.SchoolData
import com.silso.additional_weather_app.data.SimpleData
import com.silso.additional_weather_app.data.TimeData

class MainViewModel(private var repository: WeatherRepository) : ViewModel() {
    val primaryLiveData: LiveData<List<SimpleData>> = repository.primaryLiveData
    val schoolLiveData: LiveData<List<SchoolData>> = repository.schoolLiveData
    val detailLiveData: LiveData<List<SimpleData>> = repository.detailLiveData
    val timezoneLiveData: LiveData<List<TimeData>> = repository.timezoneLiveData

    fun getData(str: String) {
        repository.getWeatherData(str)
    }
}