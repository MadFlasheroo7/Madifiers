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
include(":app")
include(":madifiers-text:bionicText")
include(":madifiers-text:animateTextUnitAsState")
include(":madifiers-text:extensions")
include(":madifiers-window:windowUtils")
