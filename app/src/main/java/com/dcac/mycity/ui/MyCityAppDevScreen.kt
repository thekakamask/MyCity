package com.dcac.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.mycity.R
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.MyCityAppNavigationType

@Composable
fun MyCityDevContent(
    onDevScreenAndroidBackPressed: () -> Unit,
    navigationType: MyCityAppNavigationType) {

    BackHandler {
        onDevScreenAndroidBackPressed()
    }
    if (navigationType == MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.padding_medium), vertical = dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ){
            Image(
                painter = painterResource(id = R.drawable.image_dev),
                contentDescription = stringResource(R.string.dev_image),
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(9 / 16f)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_xsmall)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Text(
                    text = "Name:",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    text = stringResource(R.string.dev_name),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Languages:",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = stringResource(R.string.languages),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "City:",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = stringResource(R.string.dev_city),
                    style = MaterialTheme.typography.headlineSmall
                )
                LinkIconRow(navigationType = navigationType)
            }
        }
    } else {
        AnimatedVisibility(visible = navigationType == MyCityAppNavigationType.NAVIGATION_RAIL) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = dimensionResource(R.dimen.padding_small), vertical = dimensionResource(R.dimen.padding_small)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                Image(
                    painter = painterResource(id = R.drawable.image_dev),
                    contentDescription = stringResource(R.string.dev_image),
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
                        text = "Name:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.dev_name),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Languages:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = stringResource(R.string.languages),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "City:",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    Text(
                        text = stringResource(R.string.dev_city),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    LinkIconRow(navigationType = navigationType)
                }
            }
        }
        AnimatedVisibility(visible = navigationType == MyCityAppNavigationType.BOTTOM_NAVIGATION) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium), vertical = dimensionResource(R.dimen.padding_small)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_dev),
                    contentDescription = stringResource(R.string.dev_image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(dimensionResource(R.dimen.padding_small))),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Name:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_xsmall))
                )
                Text(
                    text = stringResource(R.string.dev_name),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Languages:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = stringResource(R.string.languages),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "City:",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        textDecoration = TextDecoration.Underline
                    )
                )
                Text(
                    text = stringResource(R.string.dev_city),
                    style = MaterialTheme.typography.bodyMedium
                )
                LinkIconRow(navigationType = navigationType)
            }
        }
    }
}

@Composable
fun LinkIconRow(navigationType: MyCityAppNavigationType
) {
    if (navigationType == MyCityAppNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.padding_large)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_linked_in),
                contentDescription = stringResource(R.string.logo_linked_in),
                modifier = Modifier.size(100.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.logo_github),
                contentDescription = stringResource(R.string.logo_github),
                modifier = Modifier.size(100.dp)
            )
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_linked_in),
                contentDescription = stringResource(R.string.logo_linked_in),
                modifier = Modifier.size(40.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.logo_github),
                contentDescription = stringResource(R.string.logo_github),
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
@Preview
fun MyCityAppDevScreenPreview() {
    MyCityTheme {
        MyCityDevContent(
            onDevScreenAndroidBackPressed = {},
            navigationType = MyCityAppNavigationType.BOTTOM_NAVIGATION
        )
    }

}