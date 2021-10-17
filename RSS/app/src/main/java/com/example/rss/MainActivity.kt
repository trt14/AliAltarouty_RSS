package com.example.rss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rss.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


//http://rss.cnn.com/rss/

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var rvMain: RecyclerView
    lateinit var list: ArrayList<RVData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list = arrayListOf()
        rvMain = binding.rvMain


        rvMain.layoutManager = LinearLayoutManager(this)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://rss.cnn.com/rss/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedApi = retrofit.create(ApiInterface::class.java)
        val call = feedApi.feed
        call!!.enqueue(object : Callback<Feed?>{
            override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {
                val entries = response.body()!!
                for (i in entries.articleList!!){
                    list.add(RVData(i.title.toString(), i.link.toString(), i.description.toString()))
                }
                rvMain.adapter = RVAdapter(list)

            }

            override fun onFailure(call: Call<Feed?>, t: Throwable) {
                Log.d("Main", t.message.toString())
            }

        })
    }
}