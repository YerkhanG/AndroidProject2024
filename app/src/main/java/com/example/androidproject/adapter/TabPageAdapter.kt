package com.example.androidproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.example.androidproject.views.home.MainFragment
import com.example.androidproject.views.comics.ComicsFragment
import com.example.androidproject.views.creators.CreatorsFragment

class TabPageAdapter(activity : FragmentActivity,private val tabCount : Int) : FragmentStateAdapter(activity) {
    override fun getItemCount() = tabCount

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            1 -> ComicsFragment()
            2 -> CreatorsFragment()
            else -> MainFragment()
        }
    }
}
