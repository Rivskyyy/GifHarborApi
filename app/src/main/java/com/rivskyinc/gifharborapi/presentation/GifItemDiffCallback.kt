package com.rivskyinc.gifharborapi.presentation

import androidx.recyclerview.widget.DiffUtil
import com.rivskyinc.gifharborapi.domain.pojo.data.Data

class GifItemDiffCallback : DiffUtil.ItemCallback<Data>(){

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {

        return oldItem == newItem

    }



}