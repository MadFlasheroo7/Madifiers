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
import pro.jayeshseth.madifiers.Versions

@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("madifiers.library.compose")
    id("madifiers.spotless")
}

rootProject.extra.apply {
    set("PUBLISH_GROUP_ID", Versions.artifactGroup)
    set("PUBLISH_ARTIFACT_ID", "animateTextUnitAsState")
    set("PUBLISH_VERSION", Versions.animateTextUnitAsState)
}

apply(from = "${rootDir}/scripts/publish-module.gradle")

android {
    namespace = libs.versions.namespace.animateTextUnitAsState.get()
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
}