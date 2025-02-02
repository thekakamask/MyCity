package com.dcac.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesParisDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppContentType
import com.dcac.mycity.ui.utils.MyCityAppNavigationType

@Composable
fun MyCityAppHomeScreen(
    myCityUiState: MyCityUiState,
    contentType: MyCityAppContentType,
    onCategoryTabPressed: ((Category) -> Unit),
    navigationType: MyCityAppNavigationType,
    onPlaceClick: (Place) -> Unit,
    onDetailScreenAndroidBackPressed: () -> Unit,
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
            )
        }
    }
}

@Preview
@Composable
fun MyCityAppScreenPreview() {
    MyCityTheme {
        val exampleUiState = MyCityUiState(
            currentCity = LocalCitiesDataProvider.cities[0],
            currentCategory = Category.MUSEUM,
            places = LocalPlacesParisDataProvider.parisPlaces,)
        MyCityAppHomeScreen(
            myCityUiState = exampleUiState,
            onPlaceClick = {},
            onDetailScreenAndroidBackPressed = {},
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION,
            contentType = MyCityAppContentType.LIST_ONLY,
            onCategoryTabPressed = {},
        )
    }
}