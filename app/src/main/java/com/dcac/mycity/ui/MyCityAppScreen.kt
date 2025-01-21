package com.dcac.mycity.ui

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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
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
import com.dcac.mycity.ui.utils.MyCityContentType
import com.dcac.mycity.ui.utils.MyCityNavigationType
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MyCityAppScreen(
    myCityUiState: MyCityUiState,
    navigationType: MyCityNavigationType,
    contentType: MyCityContentType,
    onPlaceClick: (Place) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
) {

    MyCityAppContent(
        myCityUiState = myCityUiState,
        onPlaceClick = onPlaceClick,
        navigationType = navigationType,
        onDetailScreenBackPressed = onDetailScreenBackPressed
    )
}

@Composable
private fun MyCityAppContent(
    myCityUiState: MyCityUiState,
    onPlaceClick: (Place) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    navigationType: MyCityNavigationType,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (myCityUiState.isShowingHomepage) {
            if (navigationType == MyCityNavigationType.BOTTOM_NAVIGATION) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = myCityUiState.currentCity.imageResourceId),
                        contentDescription = myCityUiState.currentCity.name,
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = myCityUiState.currentCity.name,
                            style = MaterialTheme.typography.headlineSmall,
                            maxLines = 1,
                        )
                        Text(
                            text= myCityUiState.currentCity.location,
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 1,
                        )
                    }
                }
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = myCityUiState.currentCity.imageResourceId),
                        contentDescription = myCityUiState.currentCity.name,
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = myCityUiState.currentCity.name,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            maxLines = 1,
                        )
                        Text(
                            text= myCityUiState.currentCity.location,
                            style = MaterialTheme.typography.bodyLarge,
                            maxLines = 1,
                        )
                    }
                }
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            MyCityAppList(
                myCityUiState = myCityUiState,
                onPlaceClick = onPlaceClick,
            )
        } else {
            MyCityAppDetails(
                myCityUiState = myCityUiState,
                onBackPressed = onDetailScreenBackPressed,
            )
        }
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
            onDetailScreenBackPressed = {},
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION,
            modifier = Modifier
        )
    }
}