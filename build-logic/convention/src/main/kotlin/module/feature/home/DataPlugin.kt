package module.feature.home

import app.msgbot.convention.util.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("common.data.remote")
            }

            dependencies {
                implementation(project(":common:data:local"))
                implementation(project(":common:data:remote"))
//                implementation(project(":feature:home:domain"))
            }
        }
    }
}