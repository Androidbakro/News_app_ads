package com.example.testnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testnewsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/top-headlines?country=de&category=business&apiKey=192a8af9d03b489a8830858606a5fe4c
class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadNews()
    binding.refresh.setOnRefreshListener {
        loadNews() } }

    private fun loadNews(){
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cat = intent.getStringExtra("cat")
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val code = prefs.getString("code","us")

        val callable = retrofit.create(Callable::class.java)
        callable.getNews(cat!!, code!!).enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                val news = response.body()
                val articals = news?.articles
                val adapter = NewsAdapter(this@MainActivity, articals!! )
                binding.newsRec.adapter =adapter
            binding.refresh.isRefreshing = false
            binding.progress.visibility = View.GONE }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {}
        }) } }