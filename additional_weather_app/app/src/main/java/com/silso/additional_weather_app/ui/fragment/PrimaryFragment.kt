package com.silso.additional_weather_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.ui.adapter.PrimaryAdapter
import com.silso.additional_weather_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_primary.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrimaryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_primary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModel()
        viewModel.primaryLiveData.observe(viewLifecycleOwner, Observer {
            val lim = LinearLayoutManager(activity)
            lim.orientation = LinearLayoutManager.HORIZONTAL
            primary_fragment_recyclerView.layoutManager = lim
            primary_fragment_recyclerView.adapter = PrimaryAdapter(it)
        })
    }
}
