package com.example.yana.fakername.data

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FakerFragmentAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {

    private val listFragment = arrayListOf<FakerData>()

    fun addFragment( fragment: Fragment, title: String){
        listFragment.add(FakerData(fragment, title))
    }

    override fun getItemCount() = listFragment.size
    override fun createFragment(position: Int) = listFragment[position].fragment
    fun getTitle(position: Int) = listFragment[position].title
}


data class FakerData(
    val fragment: Fragment,
    val title: String
    )