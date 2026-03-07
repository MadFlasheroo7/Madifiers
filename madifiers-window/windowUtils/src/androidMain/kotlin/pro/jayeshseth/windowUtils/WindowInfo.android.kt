package pro.jayeshseth.windowUtils

import android.content.res.Configuration
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * [isInLandscapeMode] checks if device is in landscape orientation
 */
@Composable
fun isInLandscapeMode(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

/**
 * [isGestureNavigation] checks if device is using gesture navigation bar
 */
@Composable
fun isGestureNavigation(): Boolean {
    val safeGesture =
        WindowInsets.safeGestures.asPaddingValues().calculateLeftPadding(LayoutDirection.Ltr)
    return safeGesture != 0.dp
}