package module.feature.github

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DomainPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.jvm.library")
            }

            dependencies {
//                implementation(project(":core"))
//                implementation(library("javax.inject"))
//                testImplementation(library("coroutines.test"))
//                testImplementation(library("junit"))
            }
        }
    }
}