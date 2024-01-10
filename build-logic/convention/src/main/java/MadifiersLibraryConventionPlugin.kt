import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import pro.jayeshseth.madifiers.convention.configureAndroidCompose
import pro.jayeshseth.madifiers.convention.configureKotlinAndroid
import pro.jayeshseth.madifiers.convention.libs

class MadifiersLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("madifiers.library.compose")
                apply("madifiers.spotless")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)
            }
            dependencies {
                add("implementation", libs.findLibrary("compose-material3").get())
                add("implementation", libs.findLibrary("compose-ui").get())
                add("implementation", libs.findLibrary("androidx-activity-compose").get())
            }
        }
    }
}