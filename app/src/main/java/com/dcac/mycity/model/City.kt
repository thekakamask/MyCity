package com.dcac.mycity.model

data class City(
    val id: Long,
    val name: String,
    val imageResourceId: Int,
    val location: String,
    val places: List<Place>
)
