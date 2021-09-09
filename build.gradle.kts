// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion by extra("1.5.21")
    val coroutinesVersion by extra("1.5.1")

//    val lifecycleVersion by extra("2.3.1")
//    val pagingVersion by extra("3.0.1")
//    val roomVersion by extra("2.3.0")
    val composeVersion by extra("1.0.2")

//    val koinVersion by extra("3.1.2")
    val coilVersion by extra("1.3.2")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlinVersion"]}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
