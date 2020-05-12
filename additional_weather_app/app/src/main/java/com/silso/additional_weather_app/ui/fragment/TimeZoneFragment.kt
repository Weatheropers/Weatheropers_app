package com.silso.additional_weather_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.ui.adapter.TimeZoneAdapter
import com.silso.additional_weather_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_time.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimeZoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModel()
        viewModel.timezoneLiveData.observe(viewLifecycleOwner, Observer {
            val lim = LinearLayoutManager(activity)
            lim.orientation = LinearLayoutManager.HORIZONTAL
            time_zone_fragment_recyclerView.layoutManager = lim
            time_zone_fragment_recyclerView.adapter = TimeZoneAdapter(it)
        })
    }
}
