plugins {
    kotlin("js")
}

kotlin {
    js {
        browser()
    }
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers/")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    api(kotlin("stdlib-js"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.6.0")
}
