package com.dcac.mycity.model

import androidx.annotation.DrawableRes

data class City(
    val id: Long,
    val name: String,
    @DrawableRes
    val imageIconId: Int,
    @DrawableRes
    val imageResourceId: Int,
    val location: String,
    val places: List<Place>
)
