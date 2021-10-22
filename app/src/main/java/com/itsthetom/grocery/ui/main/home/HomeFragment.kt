package com.itsthetom.grocery.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.itsthetom.grocery.R
import com.itsthetom.grocery.databinding.FragmentHomeBinding
import com.itsthetom.grocery.model.DummyData
import com.itsthetom.grocery.model.GroceryItem
import com.itsthetom.grocery.ui.main.home.rvadapters.*
import com.itsthetom.grocery.util.Constants
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class HomeFragment : Fragment(),RvAdapterListener{

    private lateinit var binding:FragmentHomeBinding
    private lateinit var offersSliderAdapter: ImageSliderAdapter
    private lateinit var exlusiveOffierRvAdapter: ExOfferRvAdapter
    private lateinit var groceriesWideAdapter: GroceriesWideAdapter
    private lateinit var bestSellingRvAdapter: BestSellingRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater)
        initUi()
        return binding.root
    }

    private fun initUi() {
        binding.searchViewStore.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
                                .setTextColor(resources.getColor(R.color.dark_gray,null))


    //  Initialzing  Banner Image Slider View to display Discounts and Offers
        offersSliderAdapter= ImageSliderAdapter()
        binding.exlusiveOffierSlider.setSliderAdapter(offersSliderAdapter)
        binding.exlusiveOffierSlider.setIndicatorAnimation(IndicatorAnimationType.WORM)
        binding.exlusiveOffierSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.exlusiveOffierSlider.startAutoCycle()

    //  Intializing Exclusive Offers Recycler View
        exlusiveOffierRvAdapter= ExOfferRvAdapter(this)
        exlusiveOffierRvAdapter.submitList(DummyData.fruitsList.toList())
        binding.rvExclusiveOffers.adapter=exlusiveOffierRvAdapter
        binding.rvExclusiveOffers.setHasFixedSize(true)

    //  Initializing Grocery Recycler View
        groceriesWideAdapter= GroceriesWideAdapter(this)
        groceriesWideAdapter.submitList(DummyData.groceriesList.toList())
        binding.rvGroceries.adapter=groceriesWideAdapter
        binding.rvExclusiveOffers.setHasFixedSize(true)


    //  Initliazing Best Selling Groceryes Recycler View
        bestSellingRvAdapter= BestSellingRvAdapter(this)
        bestSellingRvAdapter.submitList(DummyData.bestSellingList.toList())
        binding.rvBestSellingGrocries.adapter=bestSellingRvAdapter
        binding.rvBestSellingGrocries.setHasFixedSize(true)

    }

    override fun onClickRvItem(groceryItem: GroceryItem) {
        val bundle=Bundle()
        bundle.putParcelable(Constants.GROCERY_ITEM,groceryItem)
        findNavController().navigate(R.id.action_homeFragment_to_groceryDetailFragment,bundle)
    }


}