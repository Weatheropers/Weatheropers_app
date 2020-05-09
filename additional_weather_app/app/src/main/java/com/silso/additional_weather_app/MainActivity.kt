package com.silso.additional_weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.silso.additional_weather_app.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }

    fun setFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment())
            .commit()
    }
}
