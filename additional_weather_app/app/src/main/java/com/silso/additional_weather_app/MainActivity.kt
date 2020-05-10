package com.silso.additional_weather_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.silso.additional_weather_app.fragment.primaryFragment
import com.silso.additional_weather_app.fragment.SchoolFragment
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
            .beginTransaction().apply {
                replace(R.id.primary_fragment_container, primaryFragment())
                replace(R.id.school_fragment_container, SchoolFragment())
            }.commit()
    }

    fun setSpiner() {
        val spinnerAdapter =
            ArrayAdapter.createFromResource(this, R.array.province_array, R.layout.row_spinner)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnert_main_select_name.adapter = spinnerAdapter
        spinnert_main_select_name.prompt = "(구 선택)"
        spinnert_main_select_name.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                tv_main_province_name.text = when (position) {
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
