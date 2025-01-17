package com.dcac.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dcac.mycity.R

@Composable
fun MyCityAppTopBar(modifier: Modifier) {
    Row(
        verticalAlignment= Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ){
        MyCityAppLogo(modifier = Modifier
            .size(dimensionResource(R.dimen.topbar_logo_text_size))
            .padding(start = dimensionResource(R.dimen.topbar_logo_padding)))

        ChosenCityImage(modifier = Modifier
            .padding(end = dimensionResource(R.dimen.topbar_logo_padding))
            .size(dimensionResource(R.dimen.topbar_logo_city_image_size)))
    }
}

@Composable
private fun MyCityAppLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_text),
        contentDescription = stringResource(R.string.logo_text),
        modifier = modifier
    )
}

@Composable
private fun ChosenCityImage(
    modifier: Modifier
) {
    Image(
        modifier = modifier.clip(CircleShape),
        painter = painterResource(R.drawable.icon_city_paris),
        contentDescription = stringResource(R.string.logo_image_detailed)
    )
}