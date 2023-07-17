package `in`.realogs.windowUtils

import android.content.res.Configuration
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * [ScreenDimensions] returns the screen height and width in [Dp] and [Px]
 */
@Composable
fun ScreenDimensions(): Dimensions {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    // Values in Dp
    val heightInDp = configuration.screenHeightDp.dp
    val widthInDp = configuration.screenWidthDp.dp

    // Values in Px
    val heightInPx = with(density) { heightInDp.roundToPx() }
    val widthInPx = with(density) { widthInDp.roundToPx() }

    return Dimensions(heightInDp, widthInDp, heightInPx, widthInPx)
}

/**
 * [StatusBars] returns the status bar height in [Dp] and [Px]
 */
@Composable
fun StatusBars(): Dimensions {
    val statusBarSize = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val density = LocalDensity.current

    val sizeInPx = with(density) { statusBarSize.roundToPx() }
    return Dimensions(heightInDp = statusBarSize, heightInPx = sizeInPx)
}

/**
 * [NavigationBar] returns the navigation bar height in [Dp] and [Px]
 */
@Composable
fun NavigationBar(): Dimensions {
    val navigationBarSize = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
    val density = LocalDensity.current

    val sizeInPx = with(density) { navigationBarSize.roundToPx() }
    return Dimensions(heightInDp = navigationBarSize, heightInPx = sizeInPx)
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

/**
 * [isInLandscapeMode] checks if device is in landscape orientation
 */
@Composable
fun isInLandscapeMode(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}