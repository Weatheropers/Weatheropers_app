package com.silso.additional_weather_app.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.ui.adapter.SchoolAdapter
import com.silso.additional_weather_app.data.SchoolData
import com.silso.additional_weather_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_school.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SchoolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_school, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModel()
        viewModel.schoolLiveData.observe(viewLifecycleOwner, Observer {
            val lim = LinearLayoutManager(activity)
            lim.orientation = LinearLayoutManager.VERTICAL
            school_fragment_recyclerView.layoutManager = lim
            school_fragment_recyclerView.adapter = SchoolAdapter(it)
        })
    }
}