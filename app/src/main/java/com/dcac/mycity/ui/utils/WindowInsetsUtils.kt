package com.dcac.mycity.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

// Helper function to calculate the safe padding for landscape mode
@Composable
fun calculateLandscapeSafePadding(): PaddingValues {
    val insets = WindowInsets.safeDrawing.asPaddingValues()

    if (isLandscape()) {
        val startInset = insets.calculateStartPadding(LocalLayoutDirection.current)
        val endInset = insets.calculateEndPadding(LocalLayoutDirection.current)


        return if (endInset > startInset) {
            // Camera at left (start)
            PaddingValues(start = startInset, end = 0.dp)
        } else if(startInset > endInset) {
            // Camera at right (end)
            PaddingValues(start = 0.dp, end = startInset)
        } else {
            PaddingValues(0.dp)
        }
    }
    return PaddingValues(0.dp)
}

// Helper function to check if the device is in landscape mode
@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE
}

@Composable
fun isLandscapeSmartphone(): Boolean {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp
    val screenRatio = screenWidthDp.toFloat() / screenHeightDp.toFloat()

    // Consider smartphone if ratio is large but screen stay compact
    return screenWidthDp > 600 && screenRatio > 1.5 && screenHeightDp < 600
}