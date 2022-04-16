package com.example.yana.fakername.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yana.fakername.databinding.FragmentAboutBinding
import com.example.yana.fakername.databinding.FragmentWorksBinding

class WorksFragment: Fragment() {

    private lateinit var binding: FragmentWorksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorksBinding.inflate(inflater, container, false)
        return binding.root
    }
}