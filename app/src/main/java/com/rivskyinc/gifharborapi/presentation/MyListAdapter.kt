package com.rivskyinc.gifharborapi.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rivskyinc.gifharborapi.databinding.ItemLayoutBinding
import com.rivskyinc.gifharborapi.domain.pojo.data.Data

class MyListAdapter(private val context: Context,
                    private val listener: (Data) -> Unit) : ListAdapter<Data, MyListAdapter.GifsViewHolder>(GifItemDiffCallback()) {

    var onClickListener: ((Data) -> Unit)? = null

    lateinit var mListener : AdapterView.OnItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : AdapterView.OnItemClickListener){
        mListener = listener
    }

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
        Glide.with(context).load(listOfGifs.images.fixed_height_small.url)
            .into(holder.binding.gifIv)

        holder.itemView.setOnClickListener {
            onClickListener?.invoke(listOfGifs)
            Log.d("Adapter", it.id.toString())
        }

    }
}