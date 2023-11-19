package module.common

import org.gradle.api.Plugin
import org.gradle.api.Project

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("msgbot.android.library.compose")
            }
        }
    }
}