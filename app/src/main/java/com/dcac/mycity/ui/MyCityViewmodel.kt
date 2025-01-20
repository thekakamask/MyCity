package com.dcac.mycity.ui

import androidx.lifecycle.ViewModel
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.City
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object MyCityViewmodel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        // Load cities and associates them with their places
        val availableCities = LocalCitiesDataProvider.cities.associateWith { it.places }

        val currentCity = _uiState.value.currentCity
        val currentCategory = _uiState.value.currentCategory
        val places = currentCity.places.filter { it.category == currentCategory }

        // Update UI state
        _uiState.value = MyCityUiState(
            availableCities = availableCities,
            currentCity = currentCity,
            currentCategory = currentCategory,
            places = places
        )
    }

    fun updateCurrentCity(selectedCity: City) {
        _uiState.update { currentUiState ->
            currentUiState.copy(
                currentCity = selectedCity,
                places = selectedCity.places.filter { it.category == currentUiState.currentCategory },
                isShowingHomepage = true,
                currentPlace = null
            )
        }
    }

    fun updateCurrentCategory(selectedCategory: Category) {
        _uiState.update {
            it.copy(
                currentCategory = selectedCategory,
                places = it.currentCity.places.filter { it.category == selectedCategory },
                isShowingHomepage = true,
                currentPlace = null
            )
        }
    }

    fun updateDetailsScreenState(place: Place) {
        _uiState.update {
            it.copy(
                isShowingHomepage = false,
                currentPlace = place
            )

        }
    }

    // back button of the top bar
    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                isShowingHomepage = true,
                currentPlace = null
            )
        }
    }

    fun updateHomeScreenStates() {
        _uiState.update {
            it.copy(
                isShowingHomepage = false,
                currentPlace = null
            )
        }
    }

    // android back button
    fun handleBackNavigation(): Boolean {
        return if (!_uiState.value.isShowingHomepage) {
            // if not in home page, go back to home page
            resetHomeScreenStates()
            true // handle navigation
        } else {
            false // the system handle return (closing app)
        }
    }

}