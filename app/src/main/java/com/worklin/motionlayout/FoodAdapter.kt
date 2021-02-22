package com.worklin.motionlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worklin.motionlayout.databinding.ItemCategoriesFoodBinding

class FoodAdapter() :
    ListAdapter<Food, FoodAdapter.ViewHolder>(ItemFoodCallback()) {


    class ViewHolder private constructor(val binding: ItemCategoriesFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Food) {
            with(binding){
                food = item
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCategoriesFoodBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            bind(item)
            binding.food = item
            itemView.tag = position
        }

    }

}

class ItemFoodCallback : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return newItem.id == oldItem.id
    }

}


