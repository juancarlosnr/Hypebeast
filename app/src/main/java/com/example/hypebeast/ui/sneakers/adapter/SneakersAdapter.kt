package com.example.hypebeast.ui.sneakers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hypebeast.core.BaseViewHolder
import com.example.hypebeast.data.model.sneakers.sneakers
import com.example.hypebeast.databinding.SneakersItemViewBinding

class SneakersAdapter(private val sneakerslist: List<sneakers>):RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = SneakersItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SneakersFragmentViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is SneakersFragmentViewHolder -> holder.bind(sneakerslist[position])
        }
    }

    override fun getItemCount(): Int = sneakerslist.size

    private inner class SneakersFragmentViewHolder(
        val binding:SneakersItemViewBinding,
        val context: Context):BaseViewHolder<sneakers>(binding.root) {
        override fun bind(item: sneakers) {
            Glide.with(context).load(item.sneakers_picture).centerCrop().into(binding.cardviewImgview)
            binding.cardviewTitle.text = item.sneakers_title
            binding.cardviewDescription.text = item.sneakers_description
            binding.cardviewReleaseDate.text = item.sneakers_releasedate
            binding.cardviewPrice.text = item.sneakers_price
        }
    }
}