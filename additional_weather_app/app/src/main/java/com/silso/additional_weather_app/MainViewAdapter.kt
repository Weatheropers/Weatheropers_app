package com.silso.additional_weather_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainViewAdapter: RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false))
    }
    override fun getItemCount(): Int = 3
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
}