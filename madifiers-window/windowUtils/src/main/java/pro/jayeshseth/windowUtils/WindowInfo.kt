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
@file:SuppressLint("ComposableNaming")

package pro.jayeshseth.windowUtils

import android.annotation.SuppressLint
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
 * [ScreenDimensions] returns the screen height and width in [Dp] and Px
 */
@SuppressLint("ComposableNaming")
@Composable
public fun ScreenDimensions(): Dimensions {
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
 * [StatusBars] returns the status bar height in [Dp] and Px
 */
@Composable
public fun StatusBars(): Dimensions {
  val statusBarSize = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
  val density = LocalDensity.current

  val sizeInPx = with(density) { statusBarSize.roundToPx() }
  return Dimensions(heightInDp = statusBarSize, heightInPx = sizeInPx)
}

/**
 * [NavigationBar] returns the navigation bar height in [Dp] and Px
 */
@Composable
public fun NavigationBar(): Dimensions {
  val navigationBarSize = WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()
  val density = LocalDensity.current

  val sizeInPx = with(density) { navigationBarSize.roundToPx() }
  return Dimensions(heightInDp = navigationBarSize, heightInPx = sizeInPx)
}

/**
 * [isGestureNavigation] checks if device is using gesture navigation bar
 */
@Composable
public fun isGestureNavigation(): Boolean {
  val safeGesture =
    WindowInsets.safeGestures.asPaddingValues().calculateLeftPadding(LayoutDirection.Ltr)
  return safeGesture != 0.dp
}

/**
 * [isInLandscapeMode] checks if device is in landscape orientation
 */
@Composable
public fun isInLandscapeMode(): Boolean {
  val configuration = LocalConfiguration.current
  return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}
