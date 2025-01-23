package com.dcac.mycity.model

import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.NavigationCategoriesContent

data class MyCityUiState(
    // Available cities with their associated places
    val availableCities: Map<City, List<Place>> = emptyMap(),
    // first selected city
    val currentCity: City = LocalCitiesDataProvider.cities[0],

    val navigationCategoriesContent: List<NavigationCategoriesContent> = emptyList(),
    // First selected category
    val currentCategory: Category = Category.museum,
    // Places filtered by the current city and category
    val places: List<Place> = emptyList(),
    // Detail screen state
    val currentPlace: Place? = null,
    // home page or detail page
    val isShowingDetailPage: Boolean = false,
    //Home or Devpage (NavigationDrawer)
    val isShowingDevPage: Boolean = false
)
