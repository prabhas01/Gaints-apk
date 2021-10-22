package com.itsthetom.grocery.ui.main.grocery_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.itsthetom.grocery.databinding.FragmentGroceryDetailBinding
import com.itsthetom.grocery.model.GroceryItem
import com.itsthetom.grocery.util.Constants
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class GroceryDetailFragment : Fragment() {
    private lateinit var binding:FragmentGroceryDetailBinding
    private lateinit var imageSliderAdapter: ImageSliderAdapter
    private lateinit var groceryItem:GroceryItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentGroceryDetailBinding.inflate(inflater)

//      Now can update with this grocery item data
        groceryItem = arguments?.getParcelable(Constants.GROCERY_ITEM)!!

        initUi()

        return binding.root
     }

    private fun initUi() {

        binding.tvGroceryName.text=groceryItem.name

//      Setting up Grocery Images Slider
        imageSliderAdapter= ImageSliderAdapter()
        imageSliderAdapter.addImages(groceryItem)
        binding.groceryImageSlider.setSliderAdapter(imageSliderAdapter)
        binding.groceryImageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.groceryImageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)

        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }

    }



}