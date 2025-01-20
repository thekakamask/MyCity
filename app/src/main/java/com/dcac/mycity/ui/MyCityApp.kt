package com.dcac.mycity.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState
import com.dcac.mycity.ui.utils.isLandscape

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: MyCityViewmodel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = {
            MyCityAppTopBar(
                myCityUiState = myCityUiState,
                onCitySelectedClick = { viewModel.updateCurrentCity(it) },
                // apply good padding to landscape mode for the top bar
                modifier = modifier
                    .fillMaxWidth()
            )
        },
        bottomBar = {
            val bottomNavigationContentDescription = stringResource(R.string.navigation_bottom)
            MyCityAppBottomNavigationBar(
                myCityUiState = myCityUiState,
                onTabPressed = {category: Category ->
                    viewModel.updateCurrentCategory(category)
                               },
                modifier = modifier
                    .testTag(bottomNavigationContentDescription)
            )
        }


    ){ innerPadding ->
        MyCityAppScreen(
            myCityUiState = myCityUiState,
            onTabPressed = { viewModel.updateCurrentCategory(it) },
            onPlaceClick = { viewModel.updateDetailsScreenState(it) },
            modifier = modifier.padding(innerPadding)
        )
    }
}

