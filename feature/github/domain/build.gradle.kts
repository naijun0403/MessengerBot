plugins {
    id("feature.github.domain")
}

sourceSets {
    getByName("main") {
        java.srcDirs("src/main/kotlin")
    }
}