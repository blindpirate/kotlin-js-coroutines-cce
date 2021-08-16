pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.js") version "1.5.21"
        id("org.jetbrains.kotlin.jvm") version "1.5.21"
        id("org.jetbrains.kotlin.multiplatform") version "1.5.21"
    }
}
rootProject.name = "kotlin-js-cross-module"

include(":server")
include(":client:api")
include(":client:core")
include(":client:dynamic-loaded-module")
