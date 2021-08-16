plugins {
    kotlin("js")
}

dependencies {
    api(project(":client:api"))
}

kotlin {
    js {
        browser()
    }
}
