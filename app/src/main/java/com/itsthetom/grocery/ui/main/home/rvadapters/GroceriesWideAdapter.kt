package com.itsthetom.grocery.ui.main.home.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.LayoutWideGroceriesItemBinding
import com.itsthetom.grocery.model.GroceryItem
import com.itsthetom.grocery.util.AdapterDiffUtil

class GroceriesWideAdapter(val adapterListener: RvAdapterListener) : ListAdapter<GroceryItem, GroceriesWideAdapter.GroceriesItemViewHolder>(AdapterDiffUtil) {

    override fun onBindViewHolder(holder: GroceriesItemViewHolder, position: Int) {
        val groceryItem=getItem(position)

        holder.binding.ivGroceryImage.setImageResource(groceryItem.imgId)
        holder.binding.tvGroceryName.text=groceryItem.name
        when(position%2){
            0 -> holder.binding.itemLayout.setCardBackgroundColor(holder.binding.root.resources.getColor(R.color.creamy,null))
            1 -> holder.binding.itemLayout.setCardBackgroundColor(holder.binding.root.resources.getColor(R.color.creamy_blue,null))
        }

        holder.binding.itemLayout.setOnClickListener{
            adapterListener.onClickRvItem(groceryItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceriesItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.layout_wide_groceries_item,parent,false);
        return GroceriesItemViewHolder(view)
    }


    inner class GroceriesItemViewHolder(view: View):RecyclerView.ViewHolder(view){
             val binding=LayoutWideGroceriesItemBinding.bind(view)
    }
}