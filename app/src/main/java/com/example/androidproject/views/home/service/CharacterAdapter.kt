package com.example.androidproject.views.home.service

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.databinding.ItemCharacterBinding
import com.example.androidproject.model.Character

class CharacterAdapter: ListAdapter<Character, CharacterAdapter.ViewHolder>(
    CharacterItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }

    inner class ViewHolder(
       private val binding: ItemCharacterBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            val imageURL = character.thumbnail.path + "." + character.thumbnail.extension

            with (binding) {
                characterImage.clipToOutline = true
                characterImage.outlineProvider = RoundedCornerOutlineProvider(cornerRadius = 16.toFloat())
                Glide
                    .with(root.context)
                    .load(imageURL)
                    .placeholder(androidx.constraintlayout.widget.R.drawable.abc_ratingbar_indicator_material)
                    .dontAnimate()
                    .into(characterImage)

                characterName.text = character.name
                characterDescription.text = character.description
                characterNumberOfComics.text = getNumberOfComics(character = character)
            }
        }
    }

    private fun getNumberOfComics(character: Character): String {
        val comics = character.comics.items
        val comicsText = StringBuilder("Comics No.${ character.comics.items.size } (")

        val numComicsToShow = minOf(comics.size, 2)
        for (i in 0 until numComicsToShow) {
            comicsText.append(comics[i].name)
            if (i < numComicsToShow - 1) {
                comicsText.append(", ")
            }
        }

        if (comics.size > 2) {
            comicsText.append("...)")
        }

        return comicsText.toString()
    }
}