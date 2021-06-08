package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidfinalproject.databinding.FragmentFinalBinding

class FinalFragment : Fragment() {
    private var _binding: FragmentFinalBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PartViewModel by viewModels()

    var parts: List<Stat> = listOf(
        Stat("Example Wins", "2500"),
        Stat("Example Losses","10,000"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFinalBinding.inflate(inflater, container, false)
        val mAdapter = PartAdapter(parts)
        binding.recyclerView.adapter = mAdapter
        viewModel.getParts()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}