package com.example.androidproject.views.home.service

import androidx.recyclerview.widget.DiffUtil
import com.example.androidproject.model.Character


class CharacterItemCallback: DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}