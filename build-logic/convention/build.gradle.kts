import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "pro.jayeshseth.madifiers.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        /* Spotless */
        register("spotless") {
            id = "madifiers.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }

        /* Base Internal Plugins */
        register("androidApplication") {
            id = "android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("kmpLibrary") {
            id = "kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }

        register("cmpLibrary") {
            id = "cmp.library"
            implementationClass = "CmpLibraryConventionPlugin"
        }

        /* Shared Module/Library Plugins */
        register("madifiersAndroidLibrary") {
            id = "madifiers.android.library"
            implementationClass = "MadifiersAndroidLibraryConventionPlugin"
        }

        register("madifiersCmpLibrary") {
            id = "madifiers.cmp.library"
            implementationClass = "MadifiersCmpLibraryConventionPlugin"
        }
    }
}
