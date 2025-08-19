pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "2.2.10" 
        id("org.jlleitschuh.gradle.ktlint") version "13.0.0"
    }
}

rootProject.name = "kotlin"
include(":idc")