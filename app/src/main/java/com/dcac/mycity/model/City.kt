package com.dcac.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class City(
    val id: Long,
    @StringRes
    val name: Int,
    @DrawableRes
    val imageIconId: Int,
    @DrawableRes
    val imageResourceId: Int,
    @StringRes
    val location: Int,
    val places: List<Place>
)
