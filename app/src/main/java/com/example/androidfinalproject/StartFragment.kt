package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.androidfinalproject.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.playerButton.setOnClickListener{
            binding.root.findNavController().navigate(StartFragmentDirections.actionStartFragmentToSubmitPlayerInfoFragment())
        }
        binding.clanButton.setOnClickListener{
            binding.root.findNavController().navigate(StartFragmentDirections.actionStartFragmentToSubmitClanInfoFragment())
        }
        return binding.root
    }
}