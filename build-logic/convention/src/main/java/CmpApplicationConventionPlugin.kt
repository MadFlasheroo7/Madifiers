import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import pro.jayeshseth.madifiers.convention.applyHierarchyTemplate
import pro.jayeshseth.madifiers.convention.configureAndroidTarget
import pro.jayeshseth.madifiers.convention.configureDesktopTarget
import pro.jayeshseth.madifiers.convention.configureIosTargets
import pro.jayeshseth.madifiers.convention.configureWebTarget
import pro.jayeshseth.madifiers.convention.debugImplementation
import pro.jayeshseth.madifiers.convention.libs

class CmpApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("android.application.compose")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.compose.hot-reload")
            }

            configureAndroidTarget()
            configureIosTargets()
            configureDesktopTarget()
            configureWebTarget()

            extensions.configure<KotlinMultiplatformExtension> {
                applyHierarchyTemplate()
            }

            dependencies {
                debugImplementation(libs.findLibrary("compose-ui-tooling").get())
            }
        }
    }
}