plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "lab.uro.kitori.samplejetpackcompose"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["composeVersion"].toString()
    }
}

dependencies {
    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.extra["coroutinesVersion"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${rootProject.extra["coroutinesVersion"]}")

    // androidx
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")

//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.extra["lifecycleVersion"]}")
//    implementation("androidx.lifecycle:lifecycle-common-java8:${rootProject.extra["lifecycleVersion"]}")
//
//    implementation("androidx.paging:paging-runtime:${rootProject.extra["pagingVersion"]}")
//
//    implementation("androidx.room:room-runtime:${rootProject.extra["roomVersion"]}")
//    kapt("androidx.room:room-compiler:${rootProject.extra["roomVersion"]}")
//    implementation("androidx.room:room-ktx:${rootProject.extra["roomVersion"]}")

    implementation("androidx.compose.ui:ui:${rootProject.extra["composeVersion"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["composeVersion"]}")
    implementation("androidx.compose.runtime:runtime-livedata:${rootProject.extra["composeVersion"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["composeVersion"]}")
    implementation("androidx.compose.material:material-icons-core:${rootProject.extra["composeVersion"]}")
    implementation("androidx.compose.material:material-icons-extended:${rootProject.extra["composeVersion"]}")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha06")
    implementation("androidx.paging:paging-compose:1.0.0-alpha12")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02")

    // design
    implementation("com.google.android.material:material:1.4.0")

    // accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:0.17.0")

    // image
    implementation("io.coil-kt:coil:${rootProject.extra["coilVersion"]}")
    implementation("io.coil-kt:coil-gif:${rootProject.extra["coilVersion"]}")
    implementation("io.coil-kt:coil-compose:${rootProject.extra["coilVersion"]}")

    // di
//    implementation("io.insert-koin:koin-core:${rootProject.extra["koinVersion"]}")
//    implementation("io.insert-koin:koin-android:${rootProject.extra["koinVersion"]}")
//    implementation("io.insert-koin:koin-android-compat:${rootProject.extra["koinVersion"]}")
//    implementation("io.insert-koin:koin-androidx-compose:${rootProject.extra["koinVersion"]}")

    // test
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["composeVersion"]}")
}
