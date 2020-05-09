package com.silso.additional_weather_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
        setSpiner()
    }

    fun setFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment_container,
                MainFragment()
            )
            .commit()
    }

    fun setSpiner() {
        val spinnerAdapter =
            ArrayAdapter.createFromResource(this, R.array.province_array, R.layout.row_spinner)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinner.prompt = "(구 선택)"
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                main_province_name_txt.text = when (position) {
                    0 -> "대전광역시 유성구"
                    1 -> "대전광역시 서구"
                    2 -> "대전광역시 중구"
                    3 -> "대전광역시 대덕구"
                    4 -> "대전광역시 동구"
                    else -> "에러, 다시 접속해 주십시오"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
