package com.nikeshmaharjan.androidnativenewsappdemo.domain

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikeshmaharjan.androidnativenewsappdemo.data.remote_datasource.RemoteDataRepository
import com.nikeshmaharjan.androidnativenewsappdemo.data.models.GifModel

class GifImagesViewModel() : ViewModel() {
    val imageData: MutableLiveData<List<GifModel>> by lazy{
            MutableLiveData<List<GifModel>>()
    }
    fun getGifImages(context: Context) {
        val image = RemoteDataRepository(context).getGIFImage(imageData)
    }

}