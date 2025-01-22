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
            name = R.string.paris,
            imageIconId = R.drawable.icon_city_paris,
            imageResourceId = R.drawable.image_paris,
            location = R.string.france,
            places = LocalPlacesParisDataProvider.parisPlaces
        ),
        City(
            id = 2L,
            name = R.string.london,
            imageIconId = R.drawable.icon_city_london,
            imageResourceId = R.drawable.image_london,
            location = R.string.united_kingdom,
            places = LocalPlacesLondonDataProvider.londonPlaces
        ),
        City(
            id = 3L,
            name = R.string.rome,
            imageIconId = R.drawable.icon_city_rome,
            imageResourceId = R.drawable.image_rome,
            location = R.string.italy,
            places = LocalPlacesRomeDataProvider.romePlaces
        ),
        City(
            id = 4L,
            name = R.string.new_york,
            imageIconId = R.drawable.icon_city_new_york,
            imageResourceId = R.drawable.image_new_york,
            location = R.string.united_states,
            places = LocalPlacesNewYorkDataProvider.newYorkPlaces
        )
    )
}