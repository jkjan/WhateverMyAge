package com.example.WhateverMyAge

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class Comments (val Username : String, val Comment : String)

class CommentsAdapter (val context : Context, val titlelist : ArrayList<Comments>) :
    RecyclerView.Adapter<CommentsAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_comments_adapter, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return titlelist.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(titlelist[position], context)
    }

    inner class Holder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Username = itemView.findViewById<AppCompatButton>(R.id.username)
        val Comment = itemView.findViewById<AppCompatButton>(R.id.comment)
        fun bind(comments: Comments, context: Context) {
            Username.text = comments.Username
            Comment.text = comments.Comment
        }
    }
}