package module

import app.msgbot.convention.util.androidTestImplementation
import app.msgbot.convention.util.implementation
import app.msgbot.convention.util.ksp
import app.msgbot.convention.util.library
import app.msgbot.convention.util.testImplementation
import app.msgbot.convention.util.versionInt
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.android.library.compose")
                apply("msgbot.ksp")
                apply("org.jetbrains.kotlin.plugin.parcelize")
                apply("koin")
            }

            dependencies {
                implementation(project(":core"))
//                implementation(project(":common:presentation"))
                implementation(library("activity.compose"))
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("lifecycle.runtime.compose"))
                implementation(library("navigation.compose"))
                implementation(library("compose.destinations"))
                ksp(library("compose.destinations.ksp"))
//                implementation(library("hilt.navigation"))
//                implementation(library("coil"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
                testImplementation(library("androidx.test.ext.junit"))
                testImplementation(library("espresso.core"))
            }


            extensions.getByType<LibraryExtension>().apply {
                compileSdk = versionInt("compileSdk")

                defaultConfig {
                    minSdk = versionInt("minSdk")

                    testInstrumentationRunner =
                        "app.msgbot.common.presentation.KoinTestRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }
        }
    }
}