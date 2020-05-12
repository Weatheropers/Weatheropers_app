package com.silso.additional_weather_app.ui.adapter

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.TimeData
import com.silso.additional_weather_app.databinding.TimeZoneListItemBinding

class TimeZoneAdapter(var TimeList: List<TimeData>) :
    RecyclerViewBaseAdapter<TimeData>(TimeList, R.layout.time_zone_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder.binding as TimeZoneListItemBinding).timeData = TimeList[position]
    }
}