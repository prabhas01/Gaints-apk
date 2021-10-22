package com.itsthetom.grocery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryItem(
    val name:String,
    var price:Double,
    val quantity: Int,
    val priceType:String,
    val imgId: Int
    ) : Parcelable