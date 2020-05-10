package com.silso.additional_weather_app.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StartKoin: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StartKoin)
            modules(listOf(networkModule))
        }
    }
}