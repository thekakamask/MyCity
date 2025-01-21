package com.dcac.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.mycity.R
import com.dcac.mycity.datasource.LocalCitiesDataProvider
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityNavigationType

@Composable
fun MyCityAppList(
    myCityUiState: MyCityUiState,
    navigationType: MyCityNavigationType,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn {
        items(myCityUiState.places) { place ->
            Column {
                MyCityAppListItem(
                    place = place,
                    navigationType = navigationType,
                    onPlaceClick = onPlaceClick
                )
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium))
                )
            }
        }
    }
}

@Composable
fun MyCityAppListItem(
    place: Place,
    navigationType: MyCityNavigationType,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    if (navigationType == MyCityNavigationType.NAVIGATION_RAIL) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onPlaceClick(place) }
                .padding(dimensionResource(R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = place.imageResourceId),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small)))
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xxsmall)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                )
                Text(
                    text= place.streetAddress,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                )

                Text(
                    text = place.cityLocation,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                )
                Text(
                    text = place.openingHours,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                )
            }
        }
    } else {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onPlaceClick(place) }
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = place.imageResourceId),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small)))
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                )
                Text(
                    text= place.streetAddress,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                )

                Text(
                    text = place.cityLocation,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                )
                Text(
                    text = place.openingHours,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
fun MyCityAppDetails(
    myCityUiState: MyCityUiState,
    navigationType: MyCityNavigationType,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier){

    BackHandler {
        onBackPressed()
    }

    val currentPlace = myCityUiState.currentPlace
    if (currentPlace != null) {
        if (navigationType == MyCityNavigationType.NAVIGATION_RAIL) {
            Row(modifier = modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(R.dimen.padding_small),
                    vertical = dimensionResource(R.dimen.padding_small)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)))
            {
                Image(
                    painter = painterResource(id = currentPlace.imageResourceId),
                    contentDescription = currentPlace.name,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(9 / 16f)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                    contentScale = ContentScale.Crop
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = currentPlace.name,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_xsmall))
                    )

                    Text(
                        text = "Address:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = "${currentPlace.streetAddress}, ${currentPlace.cityLocation}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Opening Hours:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = "${currentPlace.openingHours}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Description:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = currentPlace.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_small)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                Image(
                    painter = painterResource(id = currentPlace.imageResourceId),
                    contentDescription = currentPlace.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = currentPlace.name,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_xsmall))
                )

                Text(
                    text = "Address:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = "${currentPlace.streetAddress}, ${currentPlace.cityLocation}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Opening Hours:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = "${currentPlace.openingHours}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Description:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = currentPlace.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "No place selected",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun MyCityAppDetailsPreview() {
    val exampleCity = LocalCitiesDataProvider.cities[0]
    val examplePlace = exampleCity.places[0]
    val exampleUiState = MyCityUiState(
        currentCity = exampleCity,
        currentPlace = examplePlace
    )
    MyCityTheme {
        Surface {
            MyCityAppDetails(
                myCityUiState = exampleUiState,
                onBackPressed = {},
                navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            )
        }
    }
}
