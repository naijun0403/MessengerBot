plugins {
    id("feature.home.domain")
}

sourceSets {
    getByName("main") {
        java.srcDirs("src/main/kotlin")
    }
}