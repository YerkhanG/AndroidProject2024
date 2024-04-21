package com.example.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.androidproject.databinding.ActivityMainBinding
import com.example.androidproject.adapter.TabPageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setup()
    }

    private fun setup() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabBar()
    }

    private fun setupTabBar() {
        val tabAdapter = TabPageAdapter(this, binding.tabBar.tabCount)
        binding.viewPager.adapter = tabAdapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.tabBar.selectTab(binding.tabBar.getTabAt(position))
            }
        })

        binding.tabBar.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }
}