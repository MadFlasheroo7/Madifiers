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
package pro.jayeshseth.madifiers.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pro.jayeshseth.madifiers.ui.screens.AnimateTextUnitScreen
import pro.jayeshseth.madifiers.ui.screens.BionicTextScreen
import pro.jayeshseth.madifiers.ui.screens.ButtonsScreen
import pro.jayeshseth.madifiers.ui.screens.GlowButtonScreen
import pro.jayeshseth.madifiers.ui.screens.HomeScreen
import pro.jayeshseth.madifiers.ui.screens.WindowInfoScreen

const val HOME_ROUTE = "home"
const val BIONIC_TEXT_ROUTE = "bionic_text_route"
const val ANIMATED_TEXT_ROUTE = "animated_text_route"
const val WINDOW_INFO_ROUTE = "window_info_route"
const val BUTTONS_SCREEN_ROUTE = "button_screen_route"
const val GLOW_BUTTON_ROUTE = "glow_button_route"

@Composable
fun MadNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier,
    ) {
        composable(HOME_ROUTE) {
            HomeScreen(
                navigateToBionicText = { navController.navigate(BIONIC_TEXT_ROUTE) },
                navigateToAnimatedTextUnit = { navController.navigate(ANIMATED_TEXT_ROUTE) },
                navigateToWindowInfo = { navController.navigate(WINDOW_INFO_ROUTE) },
                navigateToButtonsScreen = { navController.navigate(BUTTONS_SCREEN_ROUTE) },
            )
        }

        composable(BIONIC_TEXT_ROUTE) {
            BionicTextScreen()
        }

        composable(ANIMATED_TEXT_ROUTE) {
            AnimateTextUnitScreen()
        }

        composable(WINDOW_INFO_ROUTE) {
            WindowInfoScreen()
        }

        composable(BUTTONS_SCREEN_ROUTE) {
            ButtonsScreen(navigateToGlow = { navController.navigate(GLOW_BUTTON_ROUTE) })
        }

        composable(GLOW_BUTTON_ROUTE) {
            GlowButtonScreen()
        }
    }
}