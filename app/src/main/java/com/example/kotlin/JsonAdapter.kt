package com.example.kotlin

import android.content.Context
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.ArrayList

/**
 * Created by D on 10/18/2019.
 */
class JsonAdapter(var ctx: Context,var list: ArrayList<JsonItem>):RecyclerView.Adapter<JsonAdapter.ViewHolder>() {
    lateinit var listener: OnItemClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val v = LayoutInflater.from(ctx).inflate(R.layout.json_item, parent, false)

       return ViewHolder(v);
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list.get(position)

        Log.i("onBindViewHolder", "list 0: " + list.get(0).creator);
        Log.i("onBindViewHolder","list: "+list.get(position).creator);

        val imageUrl = currentItem.imageUrl
        val creatorName = currentItem.creator
        val likeCount = currentItem.like
        val viewCount = currentItem.view

        Log.i("onBindViewHolder","creatorName: "+creatorName);

        holder.textViewCreator.setText(creatorName);
        holder.textViewLikes.text = "Likes: "+likeCount
        holder.textView.text = "Views: $viewCount"
        Glide.with(ctx).load(imageUrl).into(holder.imageView)


        holder.itemView.setOnClickListener(View.OnClickListener {
            if (listener != null) {
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        })


    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var imageView:ImageView = itemView.findViewById(R.id.image_view)
        var textViewCreator: TextView = itemView.findViewById(R.id.text_view_creator)
        var textViewLikes: TextView = itemView.findViewById(R.id.text_view_likes)
        var textView: TextView  = itemView.findViewById(R.id.text_view)


    }

    //OnClick UI
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listeners: OnItemClickListener) {
        listener = listeners
    }


}