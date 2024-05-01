package com.example.androidproject.views.comics.service

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemComicsBinding
import com.example.androidproject.model.Comics

class ComicsListAdapter: ListAdapter<Comics, ComicsListAdapter.ViewHolder>(ComicsItemCallback()) {
    inner class ViewHolder(
        private val binding: ItemComicsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comics: Comics) {
            val imageURL = comics.thumbnail.path + "." + comics.thumbnail.extension
            with(binding) {
                Glide
                    .with(root.context)
                    .load(imageURL)
                    .dontAnimate()
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(comicsImage)
                comicsTitle.text = comics.title
                comicsDesc.text = comics.description
                characters.text = getCharacterNames(comics)
            }

        }
    }
    private fun getCharacterNames(comics: Comics): String {
        val characters = comics.characters.items
        val comicsText = StringBuilder()

        for (i in characters.indices) {
            comicsText.append(characters[i].name)
            if (i < characters.size - 1) {
                comicsText.append(", ")
            }
        }

        return comicsText.toString()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemComicsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}