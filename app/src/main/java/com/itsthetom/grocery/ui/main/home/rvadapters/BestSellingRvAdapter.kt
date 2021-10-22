package com.itsthetom.grocery.ui.main.home.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.LayoutBestsellingItemBinding
import com.itsthetom.grocery.model.GroceryItem
import com.itsthetom.grocery.util.AdapterDiffUtil

class BestSellingRvAdapter(val adapterListener: RvAdapterListener): ListAdapter<GroceryItem, BestSellingRvAdapter.BestSellingItemViewHolder>(AdapterDiffUtil){

    override fun onBindViewHolder(holder: BestSellingItemViewHolder, position: Int) {
        val groceryItem=getItem(position)

        holder.binding.tvGroceryName.text=groceryItem.name
        holder.binding.ivGroceryImage.setImageResource(groceryItem.imgId)

//    When user click on grocery item, this will open Detail Fragment to show details of grocery
        holder.binding.itemLayout.setOnClickListener{
            adapterListener.onClickRvItem(groceryItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellingItemViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.layout_bestselling_item,parent,false)
        return BestSellingItemViewHolder(view)
    }

    inner class BestSellingItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding=LayoutBestsellingItemBinding.bind(view)
    }
}