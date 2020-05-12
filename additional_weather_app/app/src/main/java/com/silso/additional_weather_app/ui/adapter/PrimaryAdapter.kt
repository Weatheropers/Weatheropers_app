package com.silso.additional_weather_app.ui.adapter

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.PrimaryData
import com.silso.additional_weather_app.databinding.PrimaryListItemBinding

class PrimaryAdapter(private var primaryList: List<PrimaryData>) :
    RecyclerViewBaseAdapter<PrimaryData>(primaryList, R.layout.primary_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder.binding as PrimaryListItemBinding).primaryData = primaryList[position]
    }
}