package com.example.rss

import retrofit2.Call
import retrofit2.http.GET


//http://rss.cnn.com/rss/edition_technology.rss

interface ApiInterface {

    @get:GET("edition_technology.rss")

    val feed: Call<Feed?>?



}