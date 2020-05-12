package com.silso.additional_weather_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.silso.additional_weather_app.ui.CustomGridView

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.ui.adapter.DetailAdapter
import com.silso.additional_weather_app.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            val viewModel: MainViewModel by viewModel()
            viewModel.detailLiveData.observe(viewLifecycleOwner, Observer {
                gridView.adapter =
                    DetailAdapter(activity?.applicationContext, it)
            })
        }
    }
}
