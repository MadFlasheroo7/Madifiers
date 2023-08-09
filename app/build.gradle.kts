/*
 * Copyright 2023 Jayesh Seth
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
    id("madifiers.application.compose")
    id("madifiers.spotless")
}

android {
    namespace = libs.versions.namespace.sample.get().toString()
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.applicationId.get().toString()
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = libs.versions.version.code.get().toInt()
        versionName = libs.versions.version.name.get().toString()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(":madifiers-text:bionicText"))
    implementation(project(":madifiers-text:animateTextUnitAsState"))
    implementation(project(":madifiers-text:extensions"))
    implementation(project(":madifiers-window:windowUtils"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.window)
    implementation(libs.core.ktx)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.material.iconsExtended)
    implementation(libs.compose.material3.window)
    implementation(libs.compose.ui)
    implementation(libs.navigation.compose)
    implementation(libs.compose.ui.googleFonts)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.manifest)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.lifecycle.compiler)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.android.test.ext.junit)
}