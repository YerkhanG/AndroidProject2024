package com.example.androidproject.views.creators.service

import androidx.recyclerview.widget.DiffUtil
import com.example.androidproject.model.Creator

class CreatorsItemCallback : DiffUtil.ItemCallback<Creator>()  {
  override fun areItemsTheSame(oldItem: Creator, newItem: Creator): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: Creator, newItem: Creator): Boolean {
    return oldItem == newItem
  }

}
