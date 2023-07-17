pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Madifiers"
include(":sample")
include(":text:bionicText")
include(":text:animateTextUnitAsState")
include(":text:extensions")
include(":window:windowUtils")
