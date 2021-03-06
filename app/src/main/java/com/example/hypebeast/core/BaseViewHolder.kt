package com.example.hypebeast.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemview: View):RecyclerView.ViewHolder(itemview) {
    abstract fun bind(item: T)
}