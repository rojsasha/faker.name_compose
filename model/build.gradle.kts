plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("com.google.devtools.ksp").version("1.6.10-1.0.4")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.moshi)
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
}