package com.dcac.mycity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
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
import com.dcac.mycity.ui.utils.MyCityAppContentType
import com.dcac.mycity.ui.utils.MyCityAppNavigationType

@Composable
fun MyCityAppHomeScreen(
    myCityUiState: MyCityUiState,
    contentType: MyCityAppContentType,
    navigationType: MyCityAppNavigationType,
    onPlaceClick: (Place) -> Unit,
    onLogoAppClick: () -> Unit,
    onCitySelectedClick: (City) -> Unit,
    onCategoryTabPressed: ((Category) -> Unit),
    onDevForwardArrowClick: () -> Unit,
    onDetailScreenAndroidBackPressed: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Start
    ) {

        if (navigationType == MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
            val navigationDrawerContentDescription = stringResource(R.string.navigation_drawer)
            MyCityAppNavigationDrawer(
                myCityUiState = myCityUiState,
                onCitySelectedClick = onCitySelectedClick,
                onCategoryTabPressed = onCategoryTabPressed,
                onLogoAppClick = onLogoAppClick,
                onDevForwardArrowClick = onDevForwardArrowClick,
                modifier = Modifier
                    .weight(0.2f)
                    .fillMaxHeight()
                    .testTag(navigationDrawerContentDescription)
            )
        }
        Box(
            modifier = Modifier
                .weight(0.8f)
                .fillMaxHeight()
        ) {
            if (contentType == MyCityAppContentType.LIST_AND_DETAIL) {
                MyCityAppListAndDetails(
                    myCityUiState = myCityUiState,
                    navigationType = navigationType,
                    onPlaceClick = onPlaceClick
                )
            } else {
                if (myCityUiState.isShowingDetailPage) {
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
                        contentType = contentType
                    )
                }
            }
        }
    }
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
            contentType = MyCityAppContentType.LIST_ONLY,
            onCategoryTabPressed = {},
            onLogoAppClick = {},
            onCitySelectedClick = {},
            onDevForwardArrowClick = {}
        )
    }
}