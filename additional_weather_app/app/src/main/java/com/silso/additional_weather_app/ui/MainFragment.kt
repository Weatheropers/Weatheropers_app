package com.silso.additional_weather_app.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.silso.additional_weather_app.MainViewAdapter

import com.silso.additional_weather_app.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lim = LinearLayoutManager(activity)
        lim.orientation = LinearLayoutManager.HORIZONTAL
        main_fragment_recyclerView.layoutManager = lim
        main_fragment_recyclerView.adapter = MainViewAdapter()
    }
}
