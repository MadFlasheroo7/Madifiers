import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import pro.jayeshseth.madifiers.convention.AndroidMainImplementation
import pro.jayeshseth.madifiers.convention.CommonMainImplementation
import pro.jayeshseth.madifiers.convention.debugImplementation
import pro.jayeshseth.madifiers.convention.libs

class CmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("org.jetbrains.compose")
                apply("kmp.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            dependencies {
                AndroidMainImplementation(libs.findLibrary("core-ktx").get())
                CommonMainImplementation(libs.findLibrary("jetbrains-compose-ui").get())
                CommonMainImplementation(libs.findLibrary("jetbrains-compose-foundation").get())
                CommonMainImplementation(libs.findLibrary("jetbrains-compose-material3").get())
                CommonMainImplementation(
                    libs.findLibrary("jetbrains-compose-material-icons-core").get(),
                )
                CommonMainImplementation(
                    libs.findLibrary("jetbrains-compose-material-icons-extended").get(),
                )

                debugImplementation(libs.findLibrary("compose-ui-tooling").get())
            }
        }
    }
}