package com.silso.additional_weather_app.ui.adapter

import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.SchoolData
import com.silso.additional_weather_app.databinding.SchoolListItemBinding

class SchoolAdapter(var SchoolList: List<SchoolData>) :
    RecyclerViewBaseAdapter<SchoolData>(SchoolList, R.layout.school_list_item) {
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder.binding as SchoolListItemBinding).schoolData = SchoolList[position]
    }
}