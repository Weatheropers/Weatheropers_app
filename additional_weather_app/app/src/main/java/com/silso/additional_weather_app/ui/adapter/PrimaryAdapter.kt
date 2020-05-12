package com.silso.additional_weather_app.ui.adapter

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.SimpleData
import com.silso.additional_weather_app.databinding.PrimaryListItemBinding

class PrimaryAdapter(var SimpleList: List<SimpleData>) :
    RecyclerViewBaseAdapter<SimpleData>(SimpleList, R.layout.primary_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder.binding as PrimaryListItemBinding).primaryData = SimpleList[position]
    }
}