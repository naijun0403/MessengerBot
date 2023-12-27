plugins {
    id("feature.home.presentation")
}

android {
    namespace = "app.msgbot.feature.home.presentation"

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
    }
}