pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.0.0" 
        id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    }
}

rootProject.name = "kotlin"
include(":idc")