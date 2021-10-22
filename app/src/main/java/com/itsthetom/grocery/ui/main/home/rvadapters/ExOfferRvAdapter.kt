package com.itsthetom.grocery.ui.main.home.rvadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.LayoutOfferItemBinding
import com.itsthetom.grocery.model.GroceryItem
import com.itsthetom.grocery.util.AdapterDiffUtil

class ExOfferRvAdapter(val rvAdapterListener: RvAdapterListener) : ListAdapter<GroceryItem,ExOfferRvAdapter.ExOfferItemViewHolder>(AdapterDiffUtil){

    private val itemList: ArrayList<GroceryItem> = arrayListOf()

    override fun onBindViewHolder(holder: ExOfferItemViewHolder, position: Int) {

        val groceryItem=getItem(position)

        holder.binding.ivGroceryImage.setImageResource(groceryItem.imgId)
        holder.binding.tvGroceryName.text=groceryItem.name

        holder.binding.itemLayout.setOnClickListener{
            rvAdapterListener.onClickRvItem(groceryItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExOfferItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.layout_offer_item,parent,false)
        return ExOfferItemViewHolder(view)
    }

    fun submitList(newItemList: ArrayList<GroceryItem>){
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()

    }

    inner class ExOfferItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding=LayoutOfferItemBinding.bind(view)

    }

    companion object
}