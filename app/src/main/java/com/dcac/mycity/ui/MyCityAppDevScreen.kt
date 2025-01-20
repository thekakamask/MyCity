package com.dcac.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.dcac.mycity.R

@Composable
fun MyCityDevContent(
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier) {

    BackHandler {
        onBackPressed()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_dev),
            contentDescription = stringResource(R.string.dev_image),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

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
        LinkIconRow()
    }
}

@Composable
fun LinkIconRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
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