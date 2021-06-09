package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.androidfinalproject.databinding.FragmentFinalBinding

class FinalFragment : Fragment() {
    private var _binding: FragmentFinalBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StatViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFinalBinding.inflate(inflater, container, false)

        viewModel.getParts()

        viewModel.response.observe(viewLifecycleOwner, Observer { statList ->
            val mAdapter = StatAdapter(statList)
            binding.recyclerView.adapter = mAdapter
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}