package com.example.timelinepsh.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.timelinepsh.R
import com.example.timelinepsh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbar.title = "메인"

        binding.bottommenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.first_tab -> {
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.second_tab -> {
                    Toast.makeText(this@MainActivity, "미구현", Toast.LENGTH_SHORT).show()
                }
                R.id.first_tab -> {
                    Toast.makeText(this@MainActivity, "미구현", Toast.LENGTH_SHORT).show()
                }
                R.id.third_tab -> {
                    val intent = Intent(this@MainActivity, TimeLine::class.java)
                    startActivity(intent)
                }
                R.id.fourth_tab -> {
                    val intent = Intent(this@MainActivity, MyDining::class.java)
                    startActivity(intent)
                }
                R.id.fifth_tab -> {
                    Toast.makeText(this@MainActivity, "미구현", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}