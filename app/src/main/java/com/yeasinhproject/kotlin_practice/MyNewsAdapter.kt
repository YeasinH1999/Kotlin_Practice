package com.yeasinhproject.kotlin_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class MyNewsAdapter(private val newsList: ArrayList<News>) : RecyclerView.Adapter<MyNewsAdapter.MyViewHolder>(){

    private val fadeDuration = 1000 //FADE_DURATION in milliseconds

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,
            false)

        return MyViewHolder(itemView)


    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading

        setScaleAnimation(holder.itemView);

    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

    }

    //!------------------------ Animation Method ------------------------!\\

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = fadeDuration.toLong()
        view.startAnimation(anim)
    }

    private fun setScaleAnimation(view: View) {
        val anim = ScaleAnimation(
            0.0f,
            1.0f,
            0.0f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        anim.duration = fadeDuration.toLong()
        view.startAnimation(anim)
    }

    //!------------------------ Animation Method ------------------------!\\


}