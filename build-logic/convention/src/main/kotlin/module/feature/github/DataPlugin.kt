package module.feature.github

import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("common.data.remote")
                apply("ktorfit")
            }

            dependencies {
                implementation(project(":common:data:local"))
                implementation(project(":common:data:remote"))
                implementation(library("github.api"))
            }
        }
    }
}