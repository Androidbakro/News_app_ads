package com.example.testnewsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.testnewsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sportsBtn.setOnClickListener { openNews("sports") }
        binding.techBtn.setOnClickListener { openNews("technology") }
        binding.sicenceBtn.setOnClickListener { openNews("science") }

    }
    private fun openNews(cat:String){
        val i = Intent(this,MainActivity::class.java)
        i.putExtra("cat",cat)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.Sittings_item){
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}