plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "com.example.yana.fakername"
        namespace = "com.example.yana.fakername"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "SPOONACULAR_BASE_URL", "\"https://faker.name/api/\"")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }

    signingConfigs {
        create("release") {
            storeFile = file("Untitled")
            storePassword = "Z%UzxyHE+H2gcfpY"
            keyAlias = "faker.name"
            keyPassword = "Z%UzxyHE+H2gcfpY"
        }
    }

    flavorDimensions.add("version")
    productFlavors {
        create("prod") {
            applicationId = "kg.faker.name"
        }
        create("dev") {
            applicationId = "kg.faker.name.dev"
            dimension = "version"
            versionName = "1.0"
        }
    }
}

dependencies {
    implementation(project(":base"))
    implementation(project(":domain"))
    implementation(project(":common:compose"))
    api(project(":common:imageloading"))
    implementation(project(":ui:search"))

    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.compose.foundation.foundation)
    implementation(libs.compose.foundation.layout)
    implementation(libs.compose.material.material)
    implementation(libs.compose.animation.animation)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.constraint.layout)
    implementation(libs.compose.material.iconsext)

    implementation(libs.hilt.compose)
    implementation(libs.hilt.library)
    implementation("androidx.core:core-ktx:+")
    kapt(libs.hilt.compiler)
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.core:core-ktx:+")

    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")

    implementation("androidx.room:room-runtime:2.4.1")
    implementation("androidx.room:room-paging:2.4.1")
    kapt("androidx.room:room-compiler:2.4.1")
    implementation("androidx.room:room-ktx:2.4.2")
    implementation("androidx.compose.compiler:compiler:1.4.0-alpha02")
    implementation("androidx.compose.foundation:foundation:1.4.0-alpha03")
    implementation("androidx.compose.material:material:1.4.0-alpha03")
    implementation("androidx.compose.runtime:runtime:1.4.0-alpha03")
    implementation("androidx.compose.ui:ui:1.4.0-alpha03")
    implementation("androidx.compose.ui:ui-tooling:1.4.0-alpha03")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.0-alpha03")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.27.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.28.0")
    implementation("com.google.accompanist:accompanist-navigation-material:0.27.0")

//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation ("com.itkacher.okhttpprofiler:okhttpprofiler:1.0.7")


}