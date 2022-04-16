package com.example.yana.fakername.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.yana.fakername.R
import com.example.yana.fakername.databinding.ActivityMainBinding
import com.example.yana.fakername.fragments.*
import com.example.yana.fakername.fragmentsViewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFrameLayout()
    }


    private fun setupFrameLayout() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.main -> changeFragment(MainFragment())
                R.id.about -> changeFragment(AboutFragment())
                R.id.works -> changeFragment(WorksFragment())
                R.id.addText -> changeFragment(AddTextFragment())
                R.id.registration -> changeFragment(RegistrationFragment())
            }
            true
        }
        binding.bottomNav.selectedItemId = R.id.main
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.pop_enter,
                R.anim.pop_exit
            )
            .commit()
    }

}


