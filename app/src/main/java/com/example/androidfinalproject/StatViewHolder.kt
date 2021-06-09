package com.example.androidfinalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ListItemBinding

class StatViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentStat: Stat

    fun bindStat(stat: Stat) {
        currentStat = stat
        binding.partType.text = currentStat.name
        binding.partPrice.text = currentStat.value
    }
}