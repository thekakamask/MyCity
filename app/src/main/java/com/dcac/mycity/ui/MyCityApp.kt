package com.dcac.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesLondonDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityContentType
import com.dcac.mycity.ui.utils.MyCityNavigationType
import com.dcac.mycity.ui.utils.MyCityScreenEnum
import com.dcac.mycity.ui.utils.isLandscapeSmartphone

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
) {
    val viewModel: MyCityViewmodel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreenEnum.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreenEnum.HomePage.name
    )
    val navigationType: MyCityNavigationType
    val contentType: MyCityContentType

    when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType =MyCityNavigationType.NAVIGATION_RAIL
            contentType = MyCityContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            val isLandscapeSmartphone = isLandscapeSmartphone()
            if (isLandscapeSmartphone) {
                navigationType = MyCityNavigationType.NAVIGATION_RAIL // Display rail on smartphone landscape
                contentType = MyCityContentType.LIST_ONLY

            } else {
                navigationType = MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER // Drawer for tablet
                contentType = MyCityContentType.LIST_AND_DETAIL
            }
        }
        else -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.LIST_ONLY
        }
    }

    Scaffold(
        topBar = {
            val topBarContentDescription = stringResource(R.string.navigation_top)
            MyCityAppTopBar(
                myCityUiState = myCityUiState,
                onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                onLogoClick = {
                    viewModel.updateHomeScreenStates()
                    navController.navigate(MyCityScreenEnum.DevPage.name)
                              },
                onBackButtonClick = {
                    viewModel.resetHomeScreenStates()
                },
                onDevForwardClick = {
                    navController.navigateUp()
                    viewModel.resetHomeScreenStates()
                },
                isDevScreen = currentScreen == MyCityScreenEnum.DevPage,
                modifier = Modifier
                    .testTag(topBarContentDescription)
                    .fillMaxWidth(),
            )
        },
        bottomBar = {
            if (navigationType == MyCityNavigationType.BOTTOM_NAVIGATION && currentScreen != MyCityScreenEnum.DevPage) {
                val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
                MyCityAppBottomNavigationBar(
                    myCityUiState = myCityUiState,
                    onTabPressed = {category: Category ->
                        viewModel.updateCurrentCategory(category)
                    },
                    modifier = Modifier
                        .testTag(bottomNavigationContentDescription)
                )
            }
        }


    ){ innerPadding ->

        Row(
            modifier = Modifier
                .padding(
                    start = 0.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = 0.dp,
                    bottom = innerPadding.calculateBottomPadding(),
                )
                .fillMaxSize()
        ) {
            if (navigationType == MyCityNavigationType.NAVIGATION_RAIL) {
                val navigationRailContentDescription = stringResource(R.string.navigation_rail)
                MyCityAppNavigationRail(
                    myCityUiState = myCityUiState,
                    onTabPressed = { category: Category ->
                        viewModel.updateCurrentCategory(category)
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .testTag(navigationRailContentDescription)
                )
            }
            NavHost(
                navController = navController,
                startDestination = MyCityScreenEnum.HomePage.name,
                modifier = Modifier
            ) {
                composable(route = MyCityScreenEnum.HomePage.name) {
                    MyCityAppScreen(
                        myCityUiState = myCityUiState,
                        navigationType = navigationType,
                        contentType = contentType,
                        onPlaceClick = { viewModel.updateDetailsScreenState(it) },
                        onDetailScreenBackPressed = { viewModel.resetHomeScreenStates() },
                    )
                }
                composable(route = MyCityScreenEnum.DevPage.name) {
                    MyCityDevContent(
                        onBackPressed = {
                            navController.navigateUp()},
                        modifier = Modifier)
                }
            }
        }
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
            onPlaceClick = {},
            onDetailScreenBackPressed = {},
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION,
            contentType = MyCityContentType.LIST_ONLY
        )
    }
}

