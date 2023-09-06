package com.rivskyinc.gifharborapi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivskyinc.gifharborapi.databinding.ItemLayoutBinding
import com.rivskyinc.gifharborapi.domain.pojo.data.Data

class MyListAdapter : ListAdapter<Data, MyListAdapter.GifsViewHolder>(GifItemDiffCallback()) {

    var onClickListener: ((Data) -> Unit)? = null

    class GifsViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        return GifsViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {

        val listOfGifs = getItem(position)
        holder.binding.tvTitle.text = listOfGifs.title
        Glide.with(holder.itemView).load(listOfGifs.images.fixed_height_small.url)
            .into(holder.binding.gifIv)


        holder.itemView.setOnClickListener {
            onClickListener?.invoke(listOfGifs)
        }
    }


}

