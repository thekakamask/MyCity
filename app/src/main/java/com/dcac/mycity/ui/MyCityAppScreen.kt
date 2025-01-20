package com.dcac.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dcac.mycity.R
import com.dcac.mycity.model.Category
import com.dcac.mycity.model.MyCityUiState

@Composable
fun MyCityAppScreen(
    myCityUiState: MyCityUiState,
    onTabPressed: ((Category) -> Unit),
    modifier: Modifier = Modifier
) {

    MyCityAppContent(
        myCityUiState = myCityUiState,
        modifier = modifier
    )
}

@Composable
private fun MyCityAppContent(
    myCityUiState: MyCityUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (myCityUiState.isShowingHomepage) {
            MyCityAppList()
        } else {
            MyCityAppDetails()
        }
    }
}