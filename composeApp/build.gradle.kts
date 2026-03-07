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
@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.madifiers.cmp.application)
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {

                // project modules
                /*
                    implementation(projects.madifiersText.bionicText)
                    implementation(projects.madifiersText.animateTextUnitAsState)
                    implementation(projects.madifiersWindow.windowUtils)
                    implementation(projects.madifiersUtils.buttons)
                */
                implementation(libs.madifiers.bionicText)
                implementation(libs.madifiers.animatedTextUnit)
                implementation(libs.madifiers.madButtons)
//    implementation(libs.madifiers.windowUtils)
//    implementation(libs.bundles.madifiers)

                implementation(libs.commonmodule)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.window)
                implementation(libs.core.ktx)
                implementation(libs.compose.material3)
                implementation(libs.compose.material.iconsExtended)
                implementation(libs.compose.material3.window)
                implementation(libs.compose.ui)
                implementation(libs.shimmer)
                implementation(libs.color.picker)
                implementation(libs.navigation.compose)
                implementation(libs.navigation.compose)
                implementation(libs.compose.ui.googleFonts)
                implementation(libs.compose.ui.graphics)
                implementation(libs.compose.ui.tooling.preview)
//                debugImplementation(libs.compose.ui.manifest)
//                debugImplementation(libs.compose.ui.tooling)
                implementation(libs.lifecycle.compiler)
                implementation(libs.lifecycle.runtime)
                implementation(libs.lifecycle.viewmodel.compose)
                implementation(libs.lifecycle.viewmodel.ktx)
//                testImplementation(libs.junit)
//                androidTestImplementation(libs.androidx.test.ext.junit)
//                androidTestImplementation(libs.espresso.core)
//                androidTestImplementation(libs.android.test.ext.junit)
            }
        }
        commonMain {
            dependencies {
                implementation(projects.madifiersWindow.windowUtils)
                implementation(projects.madifiersButtons.glowingButton)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
        }
    }
}

//dependencies {
//
//    // project modules
//    /*
//        implementation(projects.madifiersText.bionicText)
//        implementation(projects.madifiersText.animateTextUnitAsState)
//        implementation(projects.madifiersWindow.windowUtils)
//        implementation(projects.madifiersUtils.buttons)
//    */
//    implementation(libs.madifiers.bionicText)
//    implementation(libs.madifiers.animatedTextUnit)
//    implementation(libs.madifiers.madButtons)
//    implementation(projects.madifiersWindow.windowUtils)
////    implementation(libs.madifiers.windowUtils)
////    implementation(libs.bundles.madifiers)
//
//    implementation(libs.commonmodule)
//    implementation(libs.androidx.activity.compose)
//    implementation(libs.androidx.window)
//    implementation(libs.core.ktx)
//    implementation(libs.compose.material3)
//    implementation(libs.compose.material.iconsExtended)
//    implementation(libs.compose.material3.window)
//    implementation(libs.compose.ui)
//    implementation(libs.shimmer)
//    implementation(libs.color.picker)
//    implementation(libs.navigation.compose)
//    implementation(libs.navigation.compose)
//    implementation(libs.compose.ui.googleFonts)
//    implementation(libs.compose.ui.graphics)
//    implementation(libs.compose.ui.tooling.preview)
//    debugImplementation(libs.compose.ui.manifest)
//    debugImplementation(libs.compose.ui.tooling)
//    implementation(libs.lifecycle.compiler)
//    implementation(libs.lifecycle.runtime)
//    implementation(libs.lifecycle.viewmodel.compose)
//    implementation(libs.lifecycle.viewmodel.ktx)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.test.ext.junit)
//    androidTestImplementation(libs.espresso.core)
//    androidTestImplementation(libs.android.test.ext.junit)
//}