import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import pro.jayeshseth.madifiers.convention.CommonMainImplementation
import pro.jayeshseth.madifiers.convention.configureKotlinAndroid
import pro.jayeshseth.madifiers.convention.configureKotlinMultiplatform
import pro.jayeshseth.madifiers.convention.libs
import pro.jayeshseth.madifiers.convention.pathToResourcePrefix

class KmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            configureKotlinMultiplatform()

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                resourcePrefix = this@with.pathToResourcePrefix()

                // Required to make debug build of app run in iOS simulator
                experimentalProperties["android.experimental.kmp.enableAndroidResources"] = "true"
            }

            dependencies {
                CommonMainImplementation(libs.findLibrary("jetbrains-lifecycle-compose").get())
            }
        }
    }
}