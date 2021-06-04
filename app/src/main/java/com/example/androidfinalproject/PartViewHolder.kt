package com.example.androidfinalproject

import androidx.recyclerview.widget.RecyclerView
import com.example.androidfinalproject.databinding.ListItemBinding

class PartViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentPart: Part

    fun bindPart(part: Part) {
        currentPart = part
        binding.partType.text = currentPart.type
        binding.partName.text = currentPart.name
        binding.partPrice.text = currentPart.price.toString()
    }
}