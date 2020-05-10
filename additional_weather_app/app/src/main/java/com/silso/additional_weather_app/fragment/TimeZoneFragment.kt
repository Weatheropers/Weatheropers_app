package com.silso.additional_weather_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.adapter.SchoolAdapter
import com.silso.additional_weather_app.adapter.TimeZoneAdapter
import kotlinx.android.synthetic.main.fragment_school.*
import kotlinx.android.synthetic.main.fragment_time.*

class TimeZoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lim = LinearLayoutManager(activity)
        lim.orientation = LinearLayoutManager.HORIZONTAL
        time_zone_fragment_recyclerView.layoutManager = lim
        time_zone_fragment_recyclerView.adapter = TimeZoneAdapter()
    }
}
