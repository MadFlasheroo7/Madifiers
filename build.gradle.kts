// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.spotless)
    alias(libs.plugins.nexus.plugin)
    alias(libs.plugins.kotlin.jvm) apply false
}

apply(from = "${rootDir}/scripts/publish-root.gradle")