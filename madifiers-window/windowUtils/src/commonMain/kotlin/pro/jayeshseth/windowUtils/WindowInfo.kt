/*
 * Copyright 2024 Jayesh Seth
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pro.jayeshseth.windowUtils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

/**
 * [ScreenDimensions] returns the screen height and width in [Dp] and Px
 */
@Composable
fun ScreenDimensions(): Dimensions {
    val windowInfo = LocalWindowInfo.current
    val density = LocalDensity.current

    val sizePx = windowInfo.containerSize

    // Values in Dp
    val heightInDp = with(density) { sizePx.height.toDp() }
    val widthInDp = with(density) { sizePx.width.toDp() }

    // Values in Px
    val heightInPx = with(density) { heightInDp.roundToPx() }
    val widthInPx = with(density) { widthInDp.roundToPx() }

    return Dimensions(heightInDp, widthInDp, heightInPx, widthInPx)
}

/**
 * [StatusBars] returns the status bar height in [Dp] and Px
 */
@Composable
fun StatusBars(): Dimensions {
    val statusBarSize = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val density = LocalDensity.current

    val sizeInPx = with(density) { statusBarSize.roundToPx() }
    return Dimensions(heightInDp = statusBarSize, heightInPx = sizeInPx)
}

/**
 * [NavigationBar] returns the navigation bar height in [Dp] and Px
 */
@Composable
fun NavigationBar(): Dimensions {
    val navigationBarSize = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
    val density = LocalDensity.current

    val sizeInPx = with(density) { navigationBarSize.roundToPx() }
    return Dimensions(heightInDp = navigationBarSize, heightInPx = sizeInPx)
}