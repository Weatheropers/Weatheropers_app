package com.silso.additional_weather_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.silso.additional_weather_app.adapter.primaryAdapter

import com.silso.additional_weather_app.R
import kotlinx.android.synthetic.main.fragment_primary.*

class PrimaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_primary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lim = LinearLayoutManager(activity)
        lim.orientation = LinearLayoutManager.HORIZONTAL
        primary_fragment_recyclerView.layoutManager = lim
        primary_fragment_recyclerView.adapter = primaryAdapter()
    }
}
