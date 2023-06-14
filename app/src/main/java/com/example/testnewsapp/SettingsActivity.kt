package com.example.testnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testnewsapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Settings"
        binding.group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.jp_btn -> changeCountry("jp")
                R.id.us_btn -> changeCountry("us")
            } } }
    private fun changeCountry(code: String){
        val prefs = getSharedPreferences("settings", MODE_PRIVATE).edit()
        prefs.putString("code", code)
        prefs.apply()
        finish()
    } }