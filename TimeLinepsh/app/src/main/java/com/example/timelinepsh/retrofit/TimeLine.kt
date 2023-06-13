package com.example.timelinepsh.retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.timelinepsh.R
import com.example.timelinepsh.databinding.ActivityTimelineBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class TimeLine : AppCompatActivity() {
    lateinit var binding: ActivityTimelineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimelineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbar.title = "타임라인"

        val bottomN = findViewById<BottomNavigationView>(R.id.bottomMenu)
        bottomN.selectedItemId = R.id.third_tab

        binding.bottomMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                        R.id.first_tab -> {
                        val intent = Intent(this@TimeLine, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.second_tab -> {
                    Toast.makeText(this@TimeLine, "미구현", Toast.LENGTH_SHORT).show()
                }
                R.id.first_tab -> {
                    Toast.makeText(this@TimeLine, "미구현", Toast.LENGTH_SHORT).show()
                }
                R.id.third_tab -> {

                }
                R.id.fourth_tab -> {

                }
                R.id.fifth_tab -> {
                    Toast.makeText(this@TimeLine, "미구현", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        val tabLayout = binding.tabs

        val viewPager = binding.viewpager


        viewPager.adapter= MyFragmentPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "추천"
                }

                1 -> {
                    tab.text = "팔로잉"
                }
            }
        }.attach()
    }

    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments= listOf(RecoFragment(), FolwFragment())
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}