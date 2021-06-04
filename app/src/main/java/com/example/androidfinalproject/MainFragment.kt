package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.androidfinalproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.submitButton.setOnClickListener{
            //put toast here with the response from the xml type box
            binding.root.findNavController().navigate(MainFragmentDirections.actionMainFragmentToFinalFragment())
        }
        return binding.root
    }
}