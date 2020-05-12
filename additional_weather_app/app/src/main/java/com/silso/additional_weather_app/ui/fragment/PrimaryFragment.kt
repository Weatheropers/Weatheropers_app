package com.silso.additional_weather_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.PrimaryData
import com.silso.additional_weather_app.databinding.PrimaryListItemBinding
import com.silso.additional_weather_app.ui.adapter.PrimaryAdapter
import com.silso.additional_weather_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_primary.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PrimaryFragment : Fragment() {
    lateinit var binding: PrimaryListItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<PrimaryListItemBinding>(inflater, R.layout.fragment_primary, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModel()
        viewModel.primaryLiveData.observe(viewLifecycleOwner, Observer {
            setData(it[0])
            setList(it)
        })
    }

    private fun setData(primaryData: PrimaryData) {
        binding.primaryData = primaryData
    }

    private fun setList(it: List<PrimaryData>) {
        val lim = LinearLayoutManager(activity)
        lim.orientation = LinearLayoutManager.HORIZONTAL
        primary_fragment_recyclerView.layoutManager = lim
        primary_fragment_recyclerView.adapter = PrimaryAdapter(it)
    }
}
