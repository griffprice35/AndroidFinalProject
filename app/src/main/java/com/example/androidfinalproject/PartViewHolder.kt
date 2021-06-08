package com.example.androidfinalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ListItemBinding

class PartViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentStat: Stat

    fun bindPart(part: Stat) {
        currentStat = part
        binding.partType.text = currentStat.name
        binding.partPrice.text = currentStat.value
    }
}