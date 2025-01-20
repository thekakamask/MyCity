package com.dcac.mycity.model

import com.dcac.mycity.datasource.LocalCitiesDataProvider

data class MyCityUiState(
    // Available cities with their associated places
    val availableCities: Map<City, List<Place>> = emptyMap(),
    // first selected city
    val currentCity: City = LocalCitiesDataProvider.cities[0],
    // First selected category
    val currentCategory: Category = Category.museum,
    // Places filtered by the current city and category
    val places: List<Place> = emptyList(),
    // Detail screen state
    val currentPlace: Place? = null,
    // cities menu
    val isCityMenuExpanded: Boolean = false,
    // home page or detail page
    val isShowingHomepage: Boolean = true
)
