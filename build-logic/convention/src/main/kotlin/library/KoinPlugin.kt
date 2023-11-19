package library

import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KoinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                implementation(library("koin.android"))
                implementation(library("koin.core.coroutines"))
                implementation(library("koin.core"))
                implementation(library("koin.androidx.workmanager"))
            }
        }
    }
}