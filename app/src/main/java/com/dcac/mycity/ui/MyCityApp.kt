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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dcac.mycity.R
import com.dcac.mycity.ui.utils.isLandscape

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            MyCityAppTopBar(
                modifier = Modifier
                    .padding(
                        if (isLandscape()) {
                            WindowInsets.safeDrawing.asPaddingValues()
                        } else {
                            WindowInsets.statusBars.asPaddingValues()
                        }
                    )
                    .fillMaxWidth()
            )
        }
    ){ innerPadding ->
        MyCityAppContent(contentPaddingValues = innerPadding)
    }
}
