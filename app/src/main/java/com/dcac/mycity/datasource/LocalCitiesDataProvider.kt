package com.dcac.mycity.datasource

import com.dcac.mycity.R
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesLondonDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesNewYorkDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesParisDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesRomeDataProvider
import com.dcac.mycity.model.City

object LocalCitiesDataProvider {
    val cities = listOf(
        City(
            id = 1L,
            name = "Paris",
            imageIconId = R.drawable.icon_city_paris,
            imageResourceId = R.drawable.image_paris,
            location = "France",
            places = LocalPlacesParisDataProvider.parisPlaces
        ),
        City(
            id = 2L,
            name = "London",
            imageIconId = R.drawable.icon_city_london,
            imageResourceId = R.drawable.image_london,
            location = "United Kingdom",
            places = LocalPlacesLondonDataProvider.londonPlaces
        ),
        City(
            id = 3L,
            name = "Rome",
            imageIconId = R.drawable.icon_city_rome,
            imageResourceId = R.drawable.image_rome,
            location = "Italy",
            places = LocalPlacesRomeDataProvider.romePlaces
        ),
        City(
            id = 4L,
            name = "New York",
            imageIconId = R.drawable.icon_city_new_york,
            imageResourceId = R.drawable.image_new_york,
            location = "United States",
            places = LocalPlacesNewYorkDataProvider.newYorkPlaces
        )
    )
}