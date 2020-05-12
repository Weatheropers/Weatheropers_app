package com.silso.additional_weather_app.data

import com.silso.additional_weather_app.R

object ImageEnum {
    fun convertImage(state: Int): Int{
        return when(state){
            1, 2 -> R.drawable.sunny
            3 -> R.drawable.cloudy_icon
            4 -> R.drawable.rainy
            else -> 0
        }
    }
}