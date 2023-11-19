package module

import app.msgbot.convention.util.androidTestImplementation
import app.msgbot.convention.util.debugImplementation
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.android.application.compose")
            }

            dependencies {
                implementation(project(":core"))
                implementation(library("core.ktx"))
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("activity.compose"))
                implementation(platform(library("compose.bom")))
                implementation(library("ui"))
                implementation(library("ui.graphics"))
                implementation(library("ui.tooling.preview"))
                implementation(library("material3"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(platform(library("compose.bom")))
                androidTestImplementation(library("ui.test.junit4"))
                androidTestImplementation(library("navigation.testing"))
                debugImplementation(library("ui.tooling"))
                debugImplementation(library("ui.test.manifest"))
            }
        }
    }
}
