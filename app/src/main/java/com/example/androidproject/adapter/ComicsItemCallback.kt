package com.example.androidproject.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.androidproject.model.Comics

class ComicsItemCallback : DiffUtil.ItemCallback<Comics>()  {
    override fun areItemsTheSame(oldItem: Comics, newItem: Comics): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comics, newItem: Comics): Boolean {
        return oldItem == newItem
    }

}