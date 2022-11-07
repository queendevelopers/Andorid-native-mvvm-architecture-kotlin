package com.nikeshmaharjan.androidnativenewsappdemo.presentation

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nikeshmaharjan.androidnativenewsappdemo.R
import com.nikeshmaharjan.androidnativenewsappdemo.data.models.GifModel

class CustomRecyclerAdapter(private val localDataSet: List<GifModel>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageview)
        val textView: TextView = view.findViewById(R.id.textview)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_recycler_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.setText(localDataSet[position].title)
//        viewHolder.imageView.setImageURI(Uri.parse("https://media4.giphy.com/media/cqvuTg781CHlyrqZtd/giphy.gif"));
        Glide
            .with(viewHolder.imageView.context)
            .load(localDataSet[position].images.downsized_medium.url)
            .centerCrop()
            .placeholder(android.R.drawable.progress_horizontal)
            .into(viewHolder.imageView);
    }

    override fun getItemCount(): Int {
        return localDataSet.size
    }
}
