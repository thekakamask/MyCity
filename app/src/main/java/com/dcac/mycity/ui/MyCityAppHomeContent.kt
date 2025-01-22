package com.dcac.mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.datasource.localPlacesCityDataProvider.LocalPlacesLondonDataProvider
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppNavigationType

@Composable
fun MyCityAppContent(
    myCityUiState: MyCityUiState,
    onPlaceClick: (Place) -> Unit,
    onCategoryTabPressed: ((Category) -> Unit),
    navigationType: MyCityAppNavigationType,
) {
    AnimatedVisibility(visible = navigationType == MyCityAppNavigationType.NAVIGATION_RAIL) {
        val navigationRailContentDescription = stringResource(R.string.navigation_rail)
        MyCityAppNavigationRail(
            myCityUiState = myCityUiState,
            onCategoryTabPressed = onCategoryTabPressed,
            modifier = Modifier
                .testTag(navigationRailContentDescription)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AnimatedVisibility(visible = navigationType == MyCityAppNavigationType.NAVIGATION_RAIL) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = myCityUiState.currentCity.imageResourceId),
                    contentDescription = stringResource(id = myCityUiState.currentCity.name),
                    modifier = Modifier
                        .size(60.dp)
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_large)))
                Row (horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = stringResource(id = myCityUiState.currentCity.name),
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    Text(
                        text= stringResource(id = myCityUiState.currentCity.location),
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                    )
                }
            }
        }
        AnimatedVisibility(visible = navigationType == MyCityAppNavigationType.BOTTOM_NAVIGATION) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = myCityUiState.currentCity.imageResourceId),
                    contentDescription = stringResource(id = myCityUiState.currentCity.name),
                    modifier = Modifier
                        .size(100.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(id = myCityUiState.currentCity.name),
                        style = MaterialTheme.typography.headlineSmall,
                        maxLines = 1,
                    )
                    Text(
                        text= stringResource(id = myCityUiState.currentCity.location),
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                    )
                }
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = Color.LightGray
        )
        MyCityAppList(
            myCityUiState = myCityUiState,
            navigationType = navigationType,
            onPlaceClick = onPlaceClick,
        )
    }
}

@Preview
@Composable
fun MyCityAppContentPreview() {
    MyCityTheme {
        val myCityUiState = MyCityUiState(
            currentCity = LocalCitiesDataProvider.cities[0],
            currentCategory = Category.museum,
            places = LocalPlacesLondonDataProvider.londonPlaces)
        MyCityAppContent(
            myCityUiState = myCityUiState,
            onPlaceClick = {},
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION,
            onCategoryTabPressed = {}
        )
    }
}