package com.example.yana.fakername.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.yana.fakername.R
import com.example.yana.fakername.databinding.FragmentAboutBinding
import com.example.yana.fakername.databinding.FragmentAddTextBinding

class AddTextFragment: Fragment() {

    private lateinit var binding: FragmentAddTextBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTextBinding.inflate(inflater, container, false)
        return binding.root
        onCheckboxClicked()
    }

    private fun onCheckboxClicked(){
        if (binding.checkBox.isChecked){
            binding.checkBox.isChecked = false
        }
       }
}