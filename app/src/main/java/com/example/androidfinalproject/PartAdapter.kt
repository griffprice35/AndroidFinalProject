package com.example.androidfinalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ListItemBinding

class PartAdapter(val statList: List<Stat>) : RecyclerView.Adapter<PartViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
        val part = statList[position]
        holder.bindPart(part)
    }

    override fun getItemCount(): Int {
        return statList.size
    }
}