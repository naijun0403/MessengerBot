import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "app.msgbot.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "msgbot.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "msgbot.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "msgbot.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("room") {
            id = "room"
            implementationClass = "library.RoomPlugin"
        }
        register("ktorfit") {
            id = "ktorfit"
            implementationClass = "library.KtorfitPlugin"
        }
        register("koin") {
            id = "koin"
            implementationClass = "library.KoinPlugin"
        }
        register("appModule") {
            id = "app"
            implementationClass = "module.AppPlugin"
        }
        register("coreModule") {
            id = "core"
            implementationClass = "module.CorePlugin"
        }
        register("commonDataLocalModule") {
            id = "common.data.local"
            implementationClass = "module.common.data.LocalDataPlugin"
        }
        register("commonDataRemoteModule") {
            id = "common.data.remote"
            implementationClass = "module.common.data.RemoteDataPlugin"
        }
        register("commonPresentationModule") {
            id = "common.presentation"
            implementationClass = "module.common.PresentationPlugin"
        }
        register("featureGithubDataModule") {
            id = "feature.github.data"
            implementationClass = "module.feature.github.DataPlugin"
        }
        register("featureGithubDomainModule") {
            id = "feature.github.domain"
            implementationClass = "module.feature.github.DomainPlugin"
        }
        register("featureHomeDataModule") {
            id = "feature.home.data"
            implementationClass = "module.feature.home.DataPlugin"
        }
        register("navigationModule") {
            id = "navigation"
            implementationClass = "module.NavigationPlugin"
        }
        register("androidLint") {
            id = "msgbot.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("jvmLibrary") {
            id = "msgbot.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
