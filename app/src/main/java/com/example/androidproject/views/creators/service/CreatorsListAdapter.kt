package com.example.androidproject.views.creators.service

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemCreatorsBinding
import com.example.androidproject.model.Creator

class CreatorsListAdapter : ListAdapter<Creator, CreatorsListAdapter.ViewHolder>(CreatorsItemCallback()) {

  inner class ViewHolder(
    private val binding: ItemCreatorsBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(creator: Creator) {
      val imageURL = "${creator.thumbnail.path}.${creator.thumbnail.extension}"
      with(binding) {
        Glide.with(itemView.context)  // Using itemView.context instead of root.context
          .load(imageURL)
          .dontAnimate()
          .placeholder(R.drawable.ic_launcher_foreground)
          .into(creatorsImage)

        creatorsName.text = creator.fullName

        // Generate a comma-separated list of comic names
        val comicsNames = creator.comics.items.joinToString(", ") { it.name }
        creatorsComics.text = comicsNames
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemCreatorsBinding.inflate(
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

