package com.dcac.mycity.model

import androidx.annotation.DrawableRes

data class Place(
    val id: Long,
    val name: String,
    @DrawableRes
    val imageResourceId: Int,
    val description: String,
    val streetAddress: String,
    val cityLocation : String,
    val openingHours: String,
    val category: Category
)
