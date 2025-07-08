plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

dependencies {
    implementation(project(":core"))
    implementation(libs.bundles.spring.web)
    implementation(libs.bundles.kotlin)
    testImplementation(libs.spring.boot.starter.test)
}

kotlin {
    jvmToolchain(17)
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
}