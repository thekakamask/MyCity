package com.dcac.mycity.datasource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dcac.mycity.R
import com.dcac.mycity.model.Category

object LocalNavigationCategoriesContentDataProvider {
    val navigationCategoriesContentLists = listOf(
        NavigationCategoriesContent(
            category = Category.MUSEUM,
            icon = R.drawable.icon_museum,
            text = R.string.museum
        ),
        NavigationCategoriesContent(
            category = Category.MAUL,
            icon = R.drawable.icon_maul,
            text = R.string.maul
        ),
        NavigationCategoriesContent(
            category = Category.RESTAURANT,
            icon = R.drawable.icon_restaurant,
            text = R.string.restaurant
        ),
        NavigationCategoriesContent(
            category = Category.BAR,
            icon = R.drawable.icon_bar,
            text = R.string.bar
        ),
        NavigationCategoriesContent(
            category = Category.NIGHTCLUB,
            icon = R.drawable.icon_nightclub,
            text = R.string.nightclub
        )
    )
}

data class NavigationCategoriesContent(
    val category: Category,
    @DrawableRes
    val icon: Int,
    @StringRes
    val text: Int
)