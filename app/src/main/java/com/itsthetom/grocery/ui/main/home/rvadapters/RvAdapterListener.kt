package com.itsthetom.grocery.ui.main.home.rvadapters

import com.itsthetom.grocery.model.GroceryItem

interface RvAdapterListener {
    fun onClickRvItem(groceryItem:GroceryItem)
}