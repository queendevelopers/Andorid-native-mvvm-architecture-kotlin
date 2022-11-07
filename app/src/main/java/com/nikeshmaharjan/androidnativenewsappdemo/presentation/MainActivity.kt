package com.nikeshmaharjan.androidnativenewsappdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikeshmaharjan.androidnativenewsappdemo.R
import com.nikeshmaharjan.androidnativenewsappdemo.domain.GifImagesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : GifImagesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(GifImagesViewModel::class.java)
        viewModel.getGifImages(this)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val llm =  LinearLayoutManager(this)
        llm.orientation= LinearLayoutManager.VERTICAL
        recyclerView.layoutManager =llm


        viewModel.imageData.observe(this,{
            Log.d("test","observer called")
            val customRecyclerAdapter= CustomRecyclerAdapter(it)
            recyclerView.adapter = customRecyclerAdapter
        })

    }
}