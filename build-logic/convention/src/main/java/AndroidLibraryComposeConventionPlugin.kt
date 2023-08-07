import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pro.jayeshseth.madifiers.convention.configureAndroidCompose
import pro.jayeshseth.madifiers.convention.configureKotlinAndroid
import pro.jayeshseth.madifiers.convention.kotlinOptions

class AndroidLibraryComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)

                kotlinOptions {
                    freeCompilerArgs = freeCompilerArgs + listOf("-Xexplicit-api=strict")
                }
            }
        }
    }
}