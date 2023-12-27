package module.feature.github

import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import app.msgbot.convention.util.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DomainPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.jvm.library")
                apply("core")
            }

            dependencies {
                implementation(project(":core"))
//                implementation(library("javax.inject"))
                testImplementation(library("coroutines.test"))
                testImplementation(library("junit"))
            }
        }
    }
}