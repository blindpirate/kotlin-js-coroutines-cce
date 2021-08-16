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
    api("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.217-kotlin-1.5.21")
    api("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.217-kotlin-1.5.21")
    api(npm("react", "17.0.2"))
    api(npm("react-dom", "17.0.2"))

    api(npm("react-bootstrap", "1.6.1"))
}
