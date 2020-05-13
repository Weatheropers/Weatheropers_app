package com.silso.additional_weather_app.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.ui.fragment.DetailFragment
import com.silso.additional_weather_app.ui.fragment.PrimaryFragment
import com.silso.additional_weather_app.ui.fragment.SchoolFragment
import com.silso.additional_weather_app.ui.fragment.TimeZoneFragment
import com.silso.additional_weather_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModel()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initional()
    }

    private fun initional() {
        val bool = isConnected()
        if(bool != null && bool) {
            viewModel.getData("0")
            setFragment()
            setSpiner()
        } else {
            makeAlert()
        }
    }

    fun setFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.primary_fragment_container, PrimaryFragment())
            replace(R.id.school_fragment_container, SchoolFragment())
            replace(R.id.detail_fragment_container, DetailFragment())
            replace(R.id.time_zone_fragment_container, TimeZoneFragment())
        }.commit()
    }

    fun setSpiner() {
        val spinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.province_array,
            R.layout.row_spinner
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnert_main_select_name.apply {
            adapter = spinnerAdapter
            prompt = "(구 선택)"
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>) {}
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val bool = isConnected()
                    if(bool != null && bool) {
                        viewModel.getData(position.toString())
                        tv_main_province_name.text = when (position) {
                            0 -> "대전광역시 유성구"
                            1 -> "대전광역시 서구"
                            2 -> "대전광역시 중구"
                            3 -> "대전광역시 대덕구"
                            4 -> "대전광역시 동구"
                            else -> "에러, 다시 접속해 주십시오"
                        }
                    } else {
                        makeAlert()
                    }
                }
            }
        }
    }

    fun isConnected(): Boolean? {
        val cm: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = cm.activeNetworkInfo ?: null
        return networkInfo?.isConnectedOrConnecting
    }

    fun makeAlert(){
        alert("네트워크 환경을 다시 한 번 확인해 주시길 바랍니다.", "인터넷 연결없음") {
            yesButton { initional() }
            noButton { this@MainActivity.finishAffinity() }
        }.show()
    }
}
