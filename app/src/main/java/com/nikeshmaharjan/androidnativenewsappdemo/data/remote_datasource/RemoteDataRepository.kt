package com.nikeshmaharjan.androidnativenewsappdemo.data.remote_datasource

import ResponseModel
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.nikeshmaharjan.androidnativenewsappdemo.core.constant.ConstantsKeys
import com.nikeshmaharjan.androidnativenewsappdemo.core.constant.MySingleton
import com.nikeshmaharjan.androidnativenewsappdemo.data.models.GifModel

class RemoteDataRepository(var context: Context) {

    fun getGIFImage(imageData:MutableLiveData<List<GifModel>>) : List<GifModel>?
    {
        val stringRequest = StringRequest(Request.Method.GET, ConstantsKeys().BASE_URL+"/gifs/trending"+ConstantsKeys().API_KEY_PARAMS,
            { response -> imageData.value= Gson().fromJson(response.toString(), ResponseModel::class.java).data},
            {error -> error.printStackTrace() })
        val queue = MySingleton.getInstance(context).addToRequestQueue(stringRequest)
    return null
    }
}

//interface GifInterface {
//    suspend fun fetchLatestNews(): List<ArticleHeadline>
//}