package com.dcac.mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
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
import com.dcac.mycity.model.Place
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppContentType
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
        backStackEntry?.destination?.route ?: MyCityAppScreenEnum.HOME_PAGE.name
    )
    val navigationType: MyCityAppNavigationType
    val contentType: MyCityAppContentType

    when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityAppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType =MyCityAppNavigationType.NAVIGATION_RAIL
            contentType = MyCityAppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            val isLandscapeSmartphone = isLandscapeSmartphone()
            if (isLandscapeSmartphone) {
                navigationType = MyCityAppNavigationType.NAVIGATION_RAIL // Display rail on smartphone landscape
                contentType = MyCityAppContentType.LIST_ONLY

            } else {
                navigationType = MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER // Drawer for tablet
                contentType = MyCityAppContentType.LIST_AND_DETAIL
            }
        }
        else -> {
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityAppContentType.LIST_ONLY
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
                        viewModel.resetHomeScreenStates()
                        navController.navigate(MyCityAppScreenEnum.DEV_PAGE.name){
                            launchSingleTop = true
                        }
                    },
                    onBackArrowClick = {
                        viewModel.resetHomeScreenStates()
                    },
                    onDevForwardArrowClick = {
                        navController.navigateUp()
                        viewModel.resetHomeScreenStates()
                    },
                    isDevScreen = currentScreen == MyCityAppScreenEnum.DEV_PAGE,
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
                        viewModel.resetHomeScreenStates()
                        navController.navigate(MyCityAppScreenEnum.DEV_PAGE.name){
                            launchSingleTop = true
                        }
                    },
                    onBackArrowClick = {
                        viewModel.resetHomeScreenStates()
                    },
                    onDevForwardArrowClick = {
                        navController.navigateUp()
                        viewModel.resetHomeScreenStates()
                    },
                    isDevScreen = currentScreen == MyCityAppScreenEnum.DEV_PAGE,
                    modifier = Modifier
                        .testTag(topBarContentDescription)
                        .fillMaxWidth(),
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(navigationType == MyCityAppNavigationType.BOTTOM_NAVIGATION && currentScreen != MyCityAppScreenEnum.DEV_PAGE) {
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
        if (navigationType == MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
            val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
            Row(modifier = Modifier.fillMaxSize()) {
                MyCityAppNavigationDrawer(
                    myCityUiState = myCityUiState,
                    onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                    onCategoryTabPressed = {
                        viewModel.updateCurrentCategory(it)
                        if(currentScreen==MyCityAppScreenEnum.DEV_PAGE){
                            navController.navigateUp()
                        }
                                           },
                    onLogoAppClick = {
                        navController.navigate(MyCityAppScreenEnum.DEV_PAGE.name){
                            launchSingleTop = true
                        }
                    },
                    onDevForwardArrowClick = { navController.navigateUp() },
                    isDevScreen = currentScreen == MyCityAppScreenEnum.DEV_PAGE,
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .testTag(navigationDrawerContentDescription)
                )
                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(
                            start = 0.dp,
                            top = innerPadding.calculateTopPadding(),
                            end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                            bottom = 0.dp
                        )
                ) {
                    MyCityNavHost(
                        navController = navController,
                        myCityUiState = myCityUiState,
                        contentType = contentType,
                        navigationType = navigationType,
                        onPlaceClick = { viewModel.updateDetailsScreenState(it) },
                        onDetailScreenAndroidBackPressed = { viewModel.resetHomeScreenStates() },
                        onCategoryTabPressed = {},
                        )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(
                        start = 0.dp,
                        top = innerPadding.calculateTopPadding(),
                        end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                        bottom = 0.dp
                    )
            ) {
                MyCityNavHost(
                    navController = navController,
                    myCityUiState = myCityUiState,
                    contentType = contentType,
                    navigationType = navigationType,
                    onPlaceClick = { viewModel.updateDetailsScreenState(it) },
                    onDetailScreenAndroidBackPressed = { viewModel.resetHomeScreenStates() },
                    onCategoryTabPressed = { viewModel.updateCurrentCategory(it) },)
            }
        }
    }
}

@Composable
fun MyCityNavHost(
    navController: NavHostController,
    myCityUiState: MyCityUiState,
    contentType: MyCityAppContentType,
    navigationType: MyCityAppNavigationType,
    onPlaceClick: (Place) -> Unit,
    onDetailScreenAndroidBackPressed: () -> Unit,
    onCategoryTabPressed: ((Category) -> Unit)
) {
    NavHost(
        navController = navController,
        startDestination = MyCityAppScreenEnum.HOME_PAGE.name
    ) {
        composable(route = MyCityAppScreenEnum.HOME_PAGE.name) {
            MyCityAppHomeScreen(
                myCityUiState = myCityUiState,
                contentType = contentType,
                navigationType = navigationType,
                onPlaceClick = onPlaceClick,
                onCategoryTabPressed = onCategoryTabPressed,
                onDetailScreenAndroidBackPressed = onDetailScreenAndroidBackPressed,
            )
        }
        composable(route = MyCityAppScreenEnum.DEV_PAGE.name) {
            MyCityDevContent(
                onDevScreenAndroidBackPressed = {
                    navController.navigateUp()
                    onDetailScreenAndroidBackPressed()
                },
                navigationType = navigationType,
            )
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
            currentCategory = Category.MUSEUM,
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
                startDestination = MyCityAppScreenEnum.HOME_PAGE.name,
                modifier = Modifier.padding(
                    start = 0.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateRightPadding(layoutDirection = LayoutDirection.Ltr),
                    bottom = 0.dp)
            ) {
                composable(route = MyCityAppScreenEnum.HOME_PAGE.name) {
                    MyCityAppHomeScreen(
                        myCityUiState = exampleUiState,
                        navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION,
                        contentType = MyCityAppContentType.LIST_ONLY,
                        onCategoryTabPressed = { /* No-op for Preview */ },
                        onPlaceClick = { /* No-op for Preview */ },
                        onDetailScreenAndroidBackPressed = { /* No-op for Preview */ },
                    )
                }
            }
        }
    }
}

