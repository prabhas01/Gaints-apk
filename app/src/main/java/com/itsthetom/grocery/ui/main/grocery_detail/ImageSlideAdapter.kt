package com.itsthetom.grocery.ui.main.grocery_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.LayoutImageSliderMdItemBinding
import com.itsthetom.grocery.model.GroceryItem
import com.smarteist.autoimageslider.SliderViewAdapter


class ImageSliderAdapter:SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {
    private var groceryImagesList= listOf<Int>()


    fun addImages(sliderItem: GroceryItem) {
        groceryImagesList=makeDummyImageOfGrocery(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_image_slider_md_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.binding.ivBackgroundImage.setImageResource(groceryImagesList[position])
    }

    override fun getCount():Int{
        return groceryImagesList.size
    }

    inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
        val binding=LayoutImageSliderMdItemBinding.bind(itemView)
    }

    private fun makeDummyImageOfGrocery(groceryItem:GroceryItem):List<Int>{
        val arrayList= listOf(groceryItem.imgId,groceryItem.imgId,groceryItem.imgId)
        return arrayList.toList()
    }
}