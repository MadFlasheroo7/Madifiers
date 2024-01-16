@file:Suppress("UnstableApiUsage")

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
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "Madifiers"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
// add your modules here
include(":madifiers-example")
include(":madifiers-text:animateTextUnitAsState")
include(":madifiers-text:bionicText")
include(":madifiers-utils:buttons")
include(":madifiers-window:windowUtils")
