package com.silso.additional_weather_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.silso.additional_weather_app.R
import com.silso.additional_weather_app.databinding.PrimaryListItemBinding
import com.silso.additional_weather_app.databinding.SchoolListItemBinding
import com.silso.additional_weather_app.databinding.TimeZoneListItemBinding

open class RecyclerViewBaseAdapter<L>(var list: List<L>, var type: Int) :
    RecyclerView.Adapter<RecyclerViewBaseAdapter.BaseViewHolder<*>>() {

    class BaseViewHolder<T>(var binding: T) : RecyclerView.ViewHolder((binding as ViewDataBinding).root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            R.layout.primary_list_item -> BaseViewHolder<PrimaryListItemBinding>(
                PrimaryListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.school_list_item -> BaseViewHolder<SchoolListItemBinding>(
                SchoolListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> BaseViewHolder<TimeZoneListItemBinding>(
                TimeZoneListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return type
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {}
}