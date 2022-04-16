package com.example.yana.fakername.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yana.fakername.databinding.FragmentAddTextBinding
import com.example.yana.fakername.databinding.FragmentDataAddBinding

class DataAddFragment: Fragment() {

    private lateinit var binding: FragmentDataAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataAddBinding.inflate(inflater, container, false)
        return binding.root
    }
}