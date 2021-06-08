package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.androidfinalproject.databinding.FragmentSubmitPlayerInfoBinding

class SubmitPlayerInfoFragment : Fragment() {
    private var _binding: FragmentSubmitPlayerInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSubmitPlayerInfoBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            binding.root.findNavController().navigate(SubmitPlayerInfoFragmentDirections.actionSubmitPlayerInfoFragmentToFinalFragment())
        }
        return binding.root
    }
}