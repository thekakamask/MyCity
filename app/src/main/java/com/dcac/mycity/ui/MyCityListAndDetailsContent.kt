package com.dcac.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dcac.mycity.R
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.model.Place

@Composable
fun MyCityAppList(
    myCityUiState: MyCityUiState,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier,
    ) {
        items(myCityUiState.places) { place ->
            MyCityAppListItem(
                place = place,
                onPlaceClick = onPlaceClick
            )
        }
    }
}

@Composable
fun MyCityAppListItem(
    place: Place,
    onPlaceClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {}
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Image(
            painter = painterResource(id = place.imageResourceId),
            contentDescription = place.name,
            modifier = Modifier
                .size(70.dp)
        )
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = place.name,
                maxLines = 1,
            )
            Text(
                text= place.streetAddress,
                maxLines = 1,
            )

            Text(
                text = place.cityLocation,
                maxLines = 1,
            )
            Text(
                text = place.openingHours,
            )
        }
    }
}

@Composable
fun MyCityAppDetails(modifier: Modifier = Modifier){

}
