package com.silso.additional_weather_app.di

import com.silso.additional_weather_app.viewmodel.MainViewModel
import com.silso.additional_weather_app.viewmodel.WeatherRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    single { WeatherRepository() }
}