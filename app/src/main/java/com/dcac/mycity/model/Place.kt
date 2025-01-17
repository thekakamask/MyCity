package com.dcac.mycity.model

data class Place(
    val id: Long,
    val name: String,
    val imageResourceId: Int,
    val description: String,
    val address: String,
    val openingHours: String,
    val category: Category
)
