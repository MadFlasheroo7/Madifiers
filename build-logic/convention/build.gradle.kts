plugins {
    `kotlin-dsl`
}

group = "pro.jayeshseth.madifiers.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("spotless") {
            id = "madifiers.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "madifiers.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "madifiers.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("madifiersLibrary") {
            id = "madifiers.library"
            implementationClass = "MadifiersLibraryConventionPlugin"
        }
    }
}
