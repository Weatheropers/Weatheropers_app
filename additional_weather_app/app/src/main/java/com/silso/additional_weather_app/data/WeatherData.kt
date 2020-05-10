package com.silso.additional_weather_app.data

data class WeatherData(
    var num: Int,
    var gu: Int,
    var time_difference: Int,
    var hour: Int,
    var temp: Int,
    var day_high_temp: Int,
    var day_low_temp: Int,
    var sky_state: Int,
    var weather_state: Int,
    var weather_kor: String,
    var rain_persent: Int,
    var expect_rain_6h: Int,
    var expect_rain_12h: Int,
    var expect_snow_6h: Int,
    var expect_snow_12h: Int,
    var wind_speed: Int,
    var wind_way: Int,
    var wind_text: Int,
    var humi: Int,
    var fine_dust: String
)