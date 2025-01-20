package com.dcac.mycity.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesLondonDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: MyCityViewmodel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            MyCityAppTopBar(
                myCityUiState = myCityUiState,
                onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                // apply good padding to landscape mode for the top bar
                modifier = modifier
                    .fillMaxWidth(),
            )
        },
        bottomBar = {
            val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
            MyCityAppBottomNavigationBar(
                myCityUiState = myCityUiState,
                onTabPressed = {category: Category ->
                    viewModel.updateCurrentCategory(category)
                               },
                modifier = modifier
                    .testTag(bottomNavigationContentDescription)
            )
        }


    ){ innerPadding ->
        MyCityAppScreen(
            myCityUiState = myCityUiState,
            onTabPressed = { viewModel.updateCurrentCategory(it) },
            onPlaceClick = { viewModel.updateDetailsScreenState(it) },
            modifier = modifier.padding(innerPadding)
            //TEST LOGCAT VOIR SI SES PROPRIETES (FILL MAX WIDTH LIGNE 33)
        )
    }
}

@Preview
@Composable
fun MyCityAppScreenPreview() {
    MyCityTheme {
        val myCityUiState = MyCityUiState(
            currentCity = LocalCitiesDataProvider.cities[0],
            currentCategory = Category.museum,
            places = LocalPlacesLondonDataProvider.londonPlaces)
        MyCityAppScreen(
            myCityUiState = myCityUiState,
            onTabPressed = {},
            onPlaceClick = {},
            modifier = Modifier
        )
    }
}

