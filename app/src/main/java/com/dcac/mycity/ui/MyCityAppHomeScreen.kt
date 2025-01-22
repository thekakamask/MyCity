package com.dcac.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesParisDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.City
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppNavigationType
import com.dcac.mycity.ui.utils.MyCityAppScreenEnum

@Composable
fun MyCityAppHomeScreen(
    myCityUiState: MyCityUiState,
    navigationType: MyCityAppNavigationType,
    currentScreen: MyCityAppScreenEnum,
    onPlaceClick: (Place) -> Unit,
    onCitySelectedClick: (City) -> Unit,
    onLogoAppClick: () -> Unit,
    onCategoryTabPressed: ((Category) -> Unit),
    onDetailScreenAndroidBackPressed: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (navigationType == MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
            val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
            MyCityAppNavigationDrawer(
                myCityUiState = myCityUiState,
                onCitySelectedClick = onCitySelectedClick,
                onCategoryTabPressed = onCategoryTabPressed,
                onLogoAppClick = onLogoAppClick,
                modifier = Modifier
                    .testTag(navigationDrawerContentDescription)
            )
            MyCityAppContent(
                myCityUiState = myCityUiState,
                onPlaceClick = onPlaceClick,
                onCategoryTabPressed = onCategoryTabPressed,
                navigationType = navigationType,
            )
        } else {
            if (myCityUiState.isShowingDetailPage){
                MyCityAppDetails(
                    myCityUiState = myCityUiState,
                    onDetailScreenAndroidBackPressed = onDetailScreenAndroidBackPressed,
                    navigationType = navigationType,
                    onCategoryTabPressed = onCategoryTabPressed
                )
            } else {
                MyCityAppContent(
                    myCityUiState = myCityUiState,
                    onPlaceClick = onPlaceClick,
                    onCategoryTabPressed = onCategoryTabPressed,
                    navigationType = navigationType,
                )
            }
        }
    }

    /*val navigationRailContentDescription = stringResource(R.string.navigation_rail)
    MyCityAppNavigationRail(
        myCityUiState = myCityUiState,
        onTabPressed = onTabPressed,
        modifier = Modifier
            .testTag(navigationRailContentDescription)
    )*/
}

@Preview
@Composable
fun MyCityAppScreenPreview() {
    MyCityTheme {
        val exampleUiState = MyCityUiState(
            currentCity = LocalCitiesDataProvider.cities[0],
            currentCategory = Category.museum,
            places = LocalPlacesParisDataProvider.parisPlaces,)
        MyCityAppHomeScreen(
            myCityUiState = exampleUiState,
            onPlaceClick = {},
            onDetailScreenAndroidBackPressed = {},
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION,
            currentScreen = MyCityAppScreenEnum.HomePage,
            onCitySelectedClick = {},
            onLogoAppClick = {},
            onCategoryTabPressed = {},
        )
    }
}