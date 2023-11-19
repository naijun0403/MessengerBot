package library

import app.msgbot.convention.util.bundle
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.ksp
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KtorfitPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(bundle("ktor"))
                ksp(library("ktorfit.ksp"))
                implementation(library("ktorfit.lib"))
            }
        }
    }
}