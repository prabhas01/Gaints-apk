package com.itsthetom.grocery.util

import androidx.recyclerview.widget.DiffUtil
import com.itsthetom.grocery.model.GroceryItem

object AdapterDiffUtil:DiffUtil.ItemCallback<GroceryItem>() {
    override fun areContentsTheSame(oldItem: GroceryItem, newItem: GroceryItem): Boolean {
        return oldItem.name.equals(newItem.name)
    }

    override fun areItemsTheSame(oldItem: GroceryItem, newItem: GroceryItem): Boolean {
        return oldItem.name.equals(newItem.name)
    }
}
