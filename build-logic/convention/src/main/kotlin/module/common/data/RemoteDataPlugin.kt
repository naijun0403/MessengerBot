package module.common.data

import app.msgbot.convention.util.androidTestImplementation
import app.msgbot.convention.util.bundle
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import app.msgbot.convention.util.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RemoteDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("koin")
            }

            dependencies {
                implementation(library("core.ktx"))
                implementation(bundle("ktor"))
//                implementation(library("kotlin.serialization"))
                testImplementation(library("junit"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(library("ui.test.junit4"))
            }
        }
    }
}