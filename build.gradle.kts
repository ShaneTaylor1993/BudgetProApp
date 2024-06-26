// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.20" apply false
    id("com.android.library") version "8.4.1" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.12"
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.20"))
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}