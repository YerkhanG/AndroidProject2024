package com.example.androidproject.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidproject.views.MainFragment
import com.example.androidproject.views.SearchFragment
import com.example.androidproject.views.WeatherFragment

class TabPageAdapter(activity : FragmentActivity,private val tabCount : Int) : FragmentStateAdapter(activity) {
    override fun getItemCount() = tabCount

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            1 -> SearchFragment()
            2 -> WeatherFragment()
            else -> MainFragment()
        }
    }
}