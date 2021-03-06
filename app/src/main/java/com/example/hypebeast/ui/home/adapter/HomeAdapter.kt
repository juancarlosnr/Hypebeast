package com.example.hypebeast.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hypebeast.core.BaseViewHolder
import com.example.hypebeast.data.model.home.news
import com.example.hypebeast.databinding.NewsItemViewBinding

class HomeAdapter(private val newslist:List<news>):RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = NewsItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeFragmentViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is HomeFragmentViewHolder -> holder.bind(newslist[position])
        }
    }

    override fun getItemCount(): Int = newslist.size

    private inner class HomeFragmentViewHolder(
        val binding:NewsItemViewBinding,
        val context:Context
    ):BaseViewHolder<news>(binding.root) {
        override fun bind(item: news) {
            Glide.with(context).load(item.news_picture).centerCrop().into(binding.imgNews)
        }
    }
}