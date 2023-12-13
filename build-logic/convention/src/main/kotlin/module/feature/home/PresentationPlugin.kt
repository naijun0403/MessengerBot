package module.feature.home

import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("feature")
            }

            dependencies {
//                implementation(project(":feature:home:domain"))
                implementation(library("localizationManager"))
            }
        }
    }
}