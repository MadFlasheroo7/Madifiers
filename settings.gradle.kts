@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}
rootProject.name = "Madifiers"

include(":app")
// add your modules here
include(":madifiers-example")
include(":madifiers-text:animateTextUnitAsState")
include(":madifiers-text:bionicText")
include(":madifiers-utils:buttons")
include(":madifiers-window:windowUtils")
