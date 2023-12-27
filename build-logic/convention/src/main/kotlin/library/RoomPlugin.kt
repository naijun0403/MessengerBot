package library

import app.msgbot.convention.util.androidTestImplementation
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.ksp
import app.msgbot.convention.util.library
import app.msgbot.convention.util.runtimeOnly
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                runtimeOnly(library("room.runtime"))
                ksp(library("room.compiler"))
                implementation(library("room.ktx"))
                androidTestImplementation(library("room.testing"))
            }
        }
    }
}