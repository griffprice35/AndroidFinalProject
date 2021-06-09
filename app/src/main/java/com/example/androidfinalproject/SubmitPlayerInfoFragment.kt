package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.androidfinalproject.databinding.FragmentSubmitPlayerInfoBinding

class SubmitPlayerInfoFragment : Fragment() {
    private var _binding: FragmentSubmitPlayerInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSubmitPlayerInfoBinding.inflate(inflater, container, false)
        val playerID : EditText = binding.enterPlayerID
        playerID.setText("%23")
        binding.submitButton.setOnClickListener{
            val action = SubmitPlayerInfoFragmentDirections.actionSubmitPlayerInfoFragmentToFinalFragment(playerID.text.toString())
            binding.root.findNavController().navigate(action)
        }
        return binding.root
    }
}