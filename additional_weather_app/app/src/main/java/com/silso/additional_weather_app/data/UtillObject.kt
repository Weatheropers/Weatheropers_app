package com.silso.additional_weather_app.data

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.silso.additional_weather_app.R
import org.jetbrains.anko.imageResource

object UtillObject {
    fun convertImage(state: Int): Int{
        return when(state){
            1, 2 -> R.drawable.sunny
            3 -> R.drawable.cloudy_icon
            4 -> R.drawable.rainy
            else -> 0
        }
    }

    fun getPhrase(weatherState: Int): String{
        return when(weatherState){
            0 -> """오늘 날씨 참 맑고 좋네요ㅎㅎ
                |산책하기에 좋은 날씨에요!""".trimMargin()
            1 -> """비가 오네요... 
                |우산을 잊지 말고 비로부터 당신을 보호하세요!""".trimMargin()
            2 -> """우박을 다른 말로 뭐라하는지 아세요? 
                |진눈깨비라고 합니다. 아프니 조심하세요~""".trimMargin()
            3 -> """눈이 오는 날, 
                |세상을 흰색으로 뒤엎는 마법을 볼 수 있는 날이에요.""".trimMargin()
            4 -> """소나기에요... 
                |잠시 지나가는 비니깐 걱정하진 마세요ㅎㅎㅎ""".trimMargin()
            else -> "제가 좋아하는 숫자는 404가 아닙니다."
        }
    }
}

@BindingAdapter("bind_image")
fun bindImage(view: ImageView, res: Int?) {
    if (res != null) {
        view.imageResource = res
    }
}