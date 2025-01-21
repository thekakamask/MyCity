package com.dcac.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Surface(
                        // apply good padding to landscape mode
                        modifier = Modifier
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
}

@Preview
@Composable
fun SportsListPreview() {
    MyCityTheme {
        Surface {
            MyCityApp(
                windowSize = WindowWidthSizeClass.Compact)
        }
    }
}