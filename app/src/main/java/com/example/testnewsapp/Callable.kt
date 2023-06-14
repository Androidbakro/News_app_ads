package com.example.testnewsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Callable {
//مسحنا كلمة كتجوري والاند والبزنس هنا وكتبناهم تحت في الكويري برمتر , وكذلك  عملنا مع كنتري
    @GET("/v2/top-headlines?apiKey=192a8af9d03b489a8830858606a5fe4c")

    fun getNews(@Query("category") cat: String, @Query("country") code: String) : Call<NewsModel>

}