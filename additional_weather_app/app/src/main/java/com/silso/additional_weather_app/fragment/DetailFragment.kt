package com.silso.additional_weather_app.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.silso.additional_weather_app.CustomGridView

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.adapter.DetailAdapter
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val gridView = activity?.findViewById<CustomGridView>(R.id.grid_detail_info)
        if (gridView != null) {
            gridView.adapter =
                DetailAdapter(activity?.applicationContext, listOf("ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ"))
        }
    }
}
