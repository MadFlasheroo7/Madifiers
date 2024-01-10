import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import pro.jayeshseth.madifiers.convention.configureAndroidCompose
import pro.jayeshseth.madifiers.convention.configureKotlinAndroid

class AndroidApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("madifiers.spotless")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureAndroidCompose(this)
                configureKotlinAndroid(this)
            }
        }
    }
}