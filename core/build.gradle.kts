plugins {
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.dependency.management)
}

dependencies {
    implementation(libs.spring.boot.starter)
    implementation(libs.bundles.kotlin)
    testImplementation(libs.spring.boot.starter.test)
}

kotlin {
    jvmToolchain(17)
}

// Enable all-open for Spring components
allOpen {
    annotation("org.springframework.stereotype.Component")
    annotation("org.springframework.stereotype.Service")
}