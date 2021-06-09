package com.example.androidfinalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ListItemBinding

class StatAdapter(val statList: List<Stat>) : RecyclerView.Adapter<StatViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        val stat = statList[position]
        holder.bindStat(stat)
    }

    override fun getItemCount(): Int {
        return statList.size
    }
}