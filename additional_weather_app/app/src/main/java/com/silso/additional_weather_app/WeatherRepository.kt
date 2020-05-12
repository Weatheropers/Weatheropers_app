package com.silso.additional_weather_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.silso.additional_weather_app.data.*
import com.silso.additional_weather_app.di.WeatherApi
import org.koin.core.KoinComponent
import org.koin.core.inject
import rx.Observer
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class WeatherRepository : KoinComponent {
    var data = listOf<WeatherData>()
    private val retrofit: WeatherApi by inject()
    private var primeData: Single<List<WeatherData>>? = null

    private val observer = object : Observer<List<WeatherData>> {
        override fun onError(e: Throwable?) {
            Log.e("error", e.toString())
        }

        override fun onNext(t: List<WeatherData>?) {
            Log.d("success", t.toString())
            if (t != null) data = t
        }

        override fun onCompleted() {
            Log.i("success", "success")
        }
    }

    fun getWeatherData(branch: String) {
        primeData = retrofit.getWeatherInfo(branch)
        primeData?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(observer)
    }

    fun getSchoolData(): LiveData<List<SchoolData>> {
        val list: List<SchoolData> = listOf(
            SchoolData("이번등교", ImageEnum.convertImage(data[1].sky_state), data[1].fine_dust),
            SchoolData("이번하교", ImageEnum.convertImage(data[4].sky_state), data[4].fine_dust),
            SchoolData("다음등교", ImageEnum.convertImage(data[9].sky_state), data[9].fine_dust),
            SchoolData("다음하교", ImageEnum.convertImage(data[12].sky_state), data[12].fine_dust)
        )
        return MutableLiveData(list)
    }

    fun getPrimaryData(): LiveData<List<SimpleData>> {
        return MutableLiveData(
            listOf(
                SimpleData("강수확률", "%", data[0].rain_persent.toString()),
                SimpleData("아침운동", "%", data[0].rain_persent.toString()),
                SimpleData("미세먼지", "단계", data[0].fine_dust)
            )
        )
    }

    fun getDetailData(): LiveData<List<SimpleData>> {
        return MutableLiveData(
            listOf(
                SimpleData("예측시간", "시", data[0].hour.toString()),
                SimpleData("습도", "%", data[0].humi.toString()),
                SimpleData("예상 강수량", "mm", data[0].expect_rain_6h.toString()),
                SimpleData("풍속", "m/s", data[0].wind_speed.toString()),
                SimpleData("미세먼지", "단계", data[0].fine_dust),
                SimpleData("초미세먼지", "단계", data[0].fine_dust)
            )
        )
    }

    fun getTimeData(): LiveData<List<TimeData>> {
        val list: MutableList<TimeData> = mutableListOf()
        for (i in data) {
            list.add(
                TimeData(
                    i.hour.toString(),
                    ImageEnum.convertImage(i.sky_state),
                    i.temp.toString(),
                    i.rain_persent.toString(),
                    i.humi.toString()
                )
            )
        }
        return MutableLiveData(list)
    }
}