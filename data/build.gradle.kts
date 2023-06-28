plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.data"
    compileSdk = libs.versions.target.sdk.version.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":base"))
    api(project(":model"))
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)

    api(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)
//    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.paging.runtime)

    api(libs.androidx.room.common)
    api(libs.androidx.paging.common)
    api(libs.timber)
    implementation(libs.androidx.core.ktx)

//    // Architecture Components
//    testImplementation(Libs.ARCH_TESTING)
//
//
    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.core:core-ktx:+")
    testImplementation(libs.okhttp.mockwebserver)

    // Retrofit
    api(libs.retrofit)
    api(libs.moshi)
    api(libs.retrofit.converter.moshi)
//    api(Libs.MOSHI_KOTLIN)

//    // Kotlin
//    implementation(Libs.KOTLIN_STDLIB)
//
    // Coroutines
    api(libs.coroutines.core)
//    testImplementation(Libs.COROUTINES_TEST)
//    implementation(Libs.COROUTINES_PLAY_SERVICE)
//
    implementation(libs.hilt.library)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.hamcrest)
//    testImplementation(libs.mockito.core)
//    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.javafaker)
//    testImplementation(libs.turbine)
//    testImplementation(libs.junit.ext)
    testImplementation(libs.assertj.core)
    testImplementation(libs.mockk)

    androidTestImplementation(libs.androidx.arc.testing)
    androidTestImplementation(libs.androidx.test.runner)
//    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.assertj.core)
//    androidTestImplementation(libs.turbine)
//    androidTestImplementation(libs.room.testing)
    androidTestImplementation(libs.coroutines.test)
    androidTestImplementation(libs.javafaker)
//
    // unit tests livedata
    testImplementation(libs.androidx.arc.testing)

    // Data store
    api(libs.datastore)
}