package pro.jayeshseth.madifiers.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import java.io.File

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            buildConfig = true
            compose = true
        }

        packaging {
            resources {
                excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            }
        }

        dependencies {
            val bom = libs.findLibrary("compose-bom").get()
            "implementation"(platform(bom))
            "testImplementation"(platform(bom))

            "debugImplementation"(libs.findLibrary("compose-ui-tooling").get())
            "debugImplementation"(libs.findLibrary("compose-ui-tooling-preview").get())
            "debugImplementation"(libs.findLibrary("compose-ui-manifest").get())
        }

        // Configure Compose Compiler metrics and reports
        extensions.configure<ComposeCompilerGradlePluginExtension> {
            val enableMetricsProvider =
                project.providers.gradleProperty("enableComposeCompilerMetrics")
            val enableMetrics = (enableMetricsProvider.orNull == "true")

            val enableReportsProvider =
                project.providers.gradleProperty("enableComposeCompilerReports")
            val enableReports = (enableReportsProvider.orNull == "true")

            if (enableMetrics) {
                metricsDestination.set(project.layout.buildDirectory.dir("compose-metrics"))
            }

            if (enableReports) {
                reportsDestination.set(project.layout.buildDirectory.dir("compose-reports"))
            }

            // Optional: Enable strong skipping mode (recommended)
            enableStrongSkippingMode.set(true)

            // Optional: Include source information in generated code
            includeSourceInformation.set(true)
        }
    }
}

private fun Project.buildComposeMetricsParameters(): List<String> {
    val metricParameters = mutableListOf<String>()
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
        val metricsFolder = File(project.buildDir, "compose-metrics")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath,
        )
    }

    val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
    val enableReports = (enableReportsProvider.orNull == "true")
    if (enableReports) {
        val reportsFolder = File(project.buildDir, "compose-reports")
        metricParameters.add("-P")
        metricParameters.add(
            "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath,
        )
    }
    return metricParameters.toList()
}