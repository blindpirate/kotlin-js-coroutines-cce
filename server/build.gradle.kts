plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.5.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<JavaExec>("bootRun") {
    dependsOn(":client:core:browserDevelopmentWebpack", ":client:dynamic-loaded-module:browserDevelopmentWebpack")

    doFirst {
        rootProject.copy {
            from("client/core/build/distributions/core.js")
            from("client/dynamic-loaded-module/build/distributions/dynamic-loaded-module.js")
            into("server/build/resources/main/static")
        }
    }
}
