package com.silso.additional_weather_app.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.data.SimpleData
import com.silso.additional_weather_app.databinding.DetailListItemBinding


class DetailAdapter(var context: Context?, var list: List<SimpleData>) : BaseAdapter() {
    inner class DetailAdapterHolder(var binding: DetailListItemBinding, var view: View)

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val holder: DetailAdapterHolder
        if (p1 == null) {
            val itemBinding: DetailListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(p2!!.context),
                R.layout.detail_list_item,
                p2,
                false
            )
            holder = DetailAdapterHolder(itemBinding, itemBinding.root)
            holder.view.tag = holder
        } else {
            holder = p1.tag as DetailAdapterHolder
        }
        holder.binding.detailData = list[p0]
        return holder.view
    }

    override fun getItem(p0: Int): Any = list[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = list.size
}