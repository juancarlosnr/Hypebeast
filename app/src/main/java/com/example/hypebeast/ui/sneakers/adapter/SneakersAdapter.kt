package com.example.hypebeast.ui.sneakers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hypebeast.core.BaseViewHolder
import com.example.hypebeast.data.model.sneakers.sneakers
import com.example.hypebeast.databinding.SneakersItemViewBinding

class SneakersAdapter(private val sneakerslist: List<sneakers>, private val itemClickListener: OnSneakerClickListener):RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnSneakerClickListener{
        fun onSneakerClick(sneakers: sneakers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = SneakersItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = SneakersFragmentViewHolder(itemBinding, parent.context)
        //return SneakersFragmentViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener{
           val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
               ?: return@setOnClickListener
            itemClickListener.onSneakerClick(sneakerslist[position])
        }
        return holder
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
        }
    }
}