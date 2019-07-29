package com.example.WhateverMyAge.Love

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat.startActivity
import com.example.WhateverMyAge.MyInformation
import com.example.WhateverMyAge.R
import com.example.WhateverMyAge.signedin
import com.example.WhateverMyAge.user_name

class LoveArticles (var ID : Int, var Userpic : String, var UserID : Int, var Username:String, var Title : String, var LoveContents : String, var Like : String, var Comments : String, var Lat : Double, var Lng : Double)

public class LoveArticlesAdapter (val context : Context, val contentlist : ArrayList<LoveArticles>, val activity: Activity) :
        RecyclerView.Adapter<LoveArticlesAdapter.Holder>() {

    public var love = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.lovearticles, parent, false
        )
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return contentlist.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(contentlist[position], context)
    }

    inner class Holder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Userpic = itemView.findViewById<AppCompatImageButton>(R.id.userpic)
        val Username = itemView.findViewById<AppCompatButton>(R.id.username)
        val LoveContents = itemView.findViewById<AppCompatButton>(R.id.lovecontents)
        val Like = itemView.findViewById<AppCompatTextView>(R.id.like)
        val Comments = itemView.findViewById<AppCompatTextView>(R.id.comments)

        fun bind(lovearticles: LoveArticles, context: Context) {
            if (lovearticles.Userpic != "") {
                val resource = context.resources.getIdentifier(lovearticles.Userpic, "drawable", context.packageName)
                Userpic.setImageResource(resource)
            } else {
                Userpic.setImageResource(R.mipmap.ic_launcher)
            }

            Username.text = lovearticles.Username
            LoveContents.text = lovearticles.LoveContents
            Like.text = lovearticles.Like
            Comments.text = lovearticles.Comments

            LoveContents.setOnClickListener {
                //var intent = Intent(LoveActivity@, WholeArticleActivity::class.java)
                //intent.putExtra("id", lovearticles.ID)
                //start
                Log.i("글 아이디는~", " " + lovearticles.ID)
                var intent = Intent(activity, com.example.WhateverMyAge.Love.Comments::class.java)
                intent.putExtra("ID", lovearticles.ID)
                activity.startActivity(intent)
            }

            Username.setOnClickListener {
                Log.i("유저 아이디는~", " " + lovearticles.UserID)
                val intent = Intent(activity, MyInformation::class.java)
                val arr : Array<String> = arrayOf(lovearticles.UserID.toString(), lovearticles.Username)
                intent.putExtra("user_info", arr)
                activity.startActivity(intent)
            }
        }
    }
}