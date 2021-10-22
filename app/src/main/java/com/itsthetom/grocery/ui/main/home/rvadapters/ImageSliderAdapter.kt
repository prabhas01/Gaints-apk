package com.itsthetom.grocery.ui.main.home.rvadapters



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.LayoutImageSliderLgItemBinding
import com.itsthetom.grocery.model.GroceryItem
import com.smarteist.autoimageslider.SliderViewAdapter


class ImageSliderAdapter:SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_image_slider_lg_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {

    }

    override fun getCount(): Int {
        return 3;
    }

   inner class SliderAdapterVH(itemView: View) : ViewHolder(itemView) {
       val binding=LayoutImageSliderLgItemBinding.bind(itemView)
    }
}