package com.silso.additional_weather_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.silso.additional_weather_app.R

class DetailAdapter(var context: Context?, var list: List<String>) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val p: View = p1
            ?: (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.detail_list_item,
                null
            )

        return p
    }

    override fun getItem(p0: Int): Any = list[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = 6
}