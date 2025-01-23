package com.dcac.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.dcac.mycity.ui.MyCityApp
import com.dcac.mycity.ui.theme.MyCityTheme
import com.dcac.mycity.ui.utils.calculateLandscapeSafePadding

/**
 * Activity for Sports app
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                val windowSize = calculateWindowSizeClass(this)
                Surface(
                    // apply good padding to landscape mode
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(calculateLandscapeSafePadding())
                ) {
                    MyCityApp(
                        windowSize = windowSize.widthSizeClass
                    )
                }
            }
        }
    }
}