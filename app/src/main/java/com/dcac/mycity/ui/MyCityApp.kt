package com.dcac.mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.LocalNavigationCategoriesContentDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesParisDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppNavigationType
import com.dcac.mycity.ui.utils.MyCityAppScreenEnum
import com.dcac.mycity.ui.utils.isLandscapeSmartphone

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
) {
    val viewModel: MyCityViewmodel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityAppScreenEnum.valueOf(
        backStackEntry?.destination?.route ?: MyCityAppScreenEnum.HomePage.name
    )
    val navigationType: MyCityAppNavigationType
    //val contentType: MyCityAppContentType

    when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION
            //contentType = MyCityAppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType =MyCityAppNavigationType.NAVIGATION_RAIL
            //contentType = MyCityAppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            val isLandscapeSmartphone = isLandscapeSmartphone()
            navigationType = if (isLandscapeSmartphone) {
                MyCityAppNavigationType.NAVIGATION_RAIL // Display rail on smartphone landscape
                //contentType = MyCityAppContentType.LIST_ONLY

            } else {
                MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER // Drawer for tablet
                //contentType = MyCityAppContentType.LIST_AND_DETAIL
            }
        }
        else -> {
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION
            //contentType = MyCityAppContentType.LIST_ONLY
        }
    }

    Scaffold(
        topBar = {
            AnimatedVisibility(navigationType == MyCityAppNavigationType.NAVIGATION_RAIL) {
                val topBarContentDescription = stringResource(R.string.navigation_top)
                MyCityAppTopBar(
                    myCityUiState = myCityUiState,
                    onCitySelectedClick = {
                        viewModel.updateCurrentCity(it)},
                    onLogoAppClick = {
                        viewModel.devToHomeScreenStates()
                        navController.navigate(MyCityAppScreenEnum.DevPage.name)
                    },
                    onBackArrowClick = {
                        viewModel.resetHomeScreenStates()
                    },
                    onDevForwardArrowClick = {
                        navController.navigateUp()
                        viewModel.resetHomeScreenStates()
                    },
                    isDevScreen = currentScreen == MyCityAppScreenEnum.DevPage,
                    modifier = Modifier
                        .testTag(topBarContentDescription)
                        .fillMaxWidth(),
                )
            }
            AnimatedVisibility(navigationType == MyCityAppNavigationType.BOTTOM_NAVIGATION) {
                val topBarContentDescription = stringResource(R.string.navigation_top)
                MyCityAppTopBar(
                    myCityUiState = myCityUiState,
                    onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                    onLogoAppClick = {
                        viewModel.devToHomeScreenStates()
                        navController.navigate(MyCityAppScreenEnum.DevPage.name)
                    },
                    onBackArrowClick = {
                        viewModel.resetHomeScreenStates()
                    },
                    onDevForwardArrowClick = {
                        navController.navigateUp()
                        viewModel.resetHomeScreenStates()
                    },
                    isDevScreen = currentScreen == MyCityAppScreenEnum.DevPage,
                    modifier = Modifier
                        .testTag(topBarContentDescription)
                        .fillMaxWidth(),
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(navigationType == MyCityAppNavigationType.BOTTOM_NAVIGATION && currentScreen != MyCityAppScreenEnum.DevPage) {
                val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
                MyCityAppBottomNavigationBar(
                    myCityUiState = myCityUiState,
                    onCategoryTabPressed = {category: Category ->
                        viewModel.updateCurrentCategory(category)
                    },
                    modifier = Modifier
                        .testTag(bottomNavigationContentDescription)
                )
            }
        }


    ){ innerPadding ->
        /*Row(
            modifier = Modifier
                .padding(
                    start = 0.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                    bottom = innerPadding.calculateBottomPadding(),
                )
                .fillMaxSize()
        ) {*/
        NavHost(
            navController = navController,
            startDestination = MyCityAppScreenEnum.HomePage.name,
            modifier = Modifier.padding(
                start = 0.dp,
                top = innerPadding.calculateTopPadding(),
                end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                bottom = 0.dp
            )
        ) {
            composable(route = MyCityAppScreenEnum.HomePage.name) {
                MyCityAppHomeScreen(
                    myCityUiState = myCityUiState,
                    navigationType = navigationType,
                    currentScreen = currentScreen,
                    onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                    onLogoAppClick = {
                        viewModel.devToHomeScreenStates()
                        navController.navigate(MyCityAppScreenEnum.DevPage.name)
                    },
                    onCategoryTabPressed = { category: Category ->
                        viewModel.updateCurrentCategory(category)
                    },
                    onPlaceClick = { viewModel.updateDetailsScreenState(it) },
                    onDetailScreenAndroidBackPressed = { viewModel.resetHomeScreenStates() },
                )
            }
            composable(route = MyCityAppScreenEnum.DevPage.name) {
                MyCityDevContent(
                    onDevScreenAndroidBackPressed = {navController.navigateUp()
                        viewModel.resetHomeScreenStates()},
                    navigationType = navigationType)
            }
        }
    }
}

@Composable
@Preview
fun MyCityAppPreview() {
    MyCityTheme {
        val exampleUiState = MyCityUiState(
            availableCities = LocalCitiesDataProvider.cities.associateWith { it.places },
            currentCity = LocalCitiesDataProvider.cities[0],
            navigationCategoriesContent = LocalNavigationCategoriesContentDataProvider.navigationCategoriesContentLists,
            currentCategory = Category.museum,
            places = LocalPlacesParisDataProvider.parisPlaces,
        )
        Scaffold(
            topBar = {
                MyCityAppTopBar(
                    myCityUiState = exampleUiState,
                    onCitySelectedClick = { /* No-op for Preview */ },
                    onLogoAppClick = { /* No-op for Preview */ },
                    onBackArrowClick = { /* No-op for Preview */ },
                    onDevForwardArrowClick = { /* No-op for Preview */ },
                    isDevScreen = false,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            bottomBar = {
                MyCityAppBottomNavigationBar(
                    myCityUiState = exampleUiState,
                    onCategoryTabPressed = { /* No-op for Preview */ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = rememberNavController(),
                startDestination = MyCityAppScreenEnum.HomePage.name,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                    bottom = 0.dp)
            ) {
                composable(route = MyCityAppScreenEnum.HomePage.name) {
                    MyCityAppHomeScreen(
                        myCityUiState = exampleUiState,
                        navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION,
                        currentScreen = MyCityAppScreenEnum.HomePage,
                        onCitySelectedClick = { /* No-op for Preview */ },
                        onLogoAppClick = { /* No-op for Preview */ },
                        onCategoryTabPressed = { /* No-op for Preview */ },
                        onPlaceClick = { /* No-op for Preview */ },
                        onDetailScreenAndroidBackPressed = { /* No-op for Preview */ }
                    )
                }
            }
        }
    }
}

