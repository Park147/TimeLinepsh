package com.example.seohyun_androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.coroutines.Dispatchers.Main

class MainRecoActivity : AppCompatActivity() {

        lateinit var binding: MainRecoActivity

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = MainRecoActivity.inflate(layoutInflater)

            setContentView(binding.root)

            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            binding.toolbar.title = "타임라인"

        }

    // 타임라인에 메뉴 추가
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_timeline, menu)
            return true
        }

    // 타임라인 클릭 시 동작
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item?.itemId) {
                R.id.action_menu -> {
                    val intent = Intent(this@MainRecoActivity, heart::class.java)
                    startActivity(intent)
                }
                else -> return super.onOptionsItemSelected(item)
            }
            return true
        }
    }