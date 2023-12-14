package module.feature.home

import app.msgbot.convention.configureKotlinJvm
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DomainPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("core")
            }

            configureKotlinJvm()

            dependencies {
                implementation(project(":core"))
//                implementation(library("javax.inject"))
                implementation(library("coroutines.test"))
                implementation(library("junit"))
            }
        }
    }
}