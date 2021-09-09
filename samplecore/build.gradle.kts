plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 26
        targetSdk = 30
        version = 1

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
    // androidx
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")

    api("androidx.compose.ui:ui:${rootProject.extra["composeVersion"]}")
    api("androidx.compose.ui:ui-tooling:${rootProject.extra["composeVersion"]}")
    api("androidx.compose.runtime:runtime-livedata:${rootProject.extra["composeVersion"]}")
    api("androidx.compose.material:material:${rootProject.extra["composeVersion"]}")
    api("androidx.compose.material:material-icons-core:${rootProject.extra["composeVersion"]}")
    api("androidx.compose.material:material-icons-extended:${rootProject.extra["composeVersion"]}")

    api("androidx.activity:activity-compose:1.3.1")
    api("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    api("androidx.navigation:navigation-compose:2.4.0-alpha06")

    // design
    implementation("com.google.android.material:material:1.4.0")

    // test
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["composeVersion"]}")
}
