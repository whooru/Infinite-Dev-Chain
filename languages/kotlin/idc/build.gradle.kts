import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.jvm.toolchain.JavaLanguageVersion
import java.util.Locale

plugins {
  id("jvm-test-suite")
  kotlin("jvm")
  id("org.jlleitschuh.gradle.ktlint")
  jacoco
}

group = "idc"
version = "0.1.0"

jacoco {
    toolVersion = "0.8.11"
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

kotlin {
  jvmToolchain(21)
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
}

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useJUnitJupiter()

      dependencies {
        implementation(platform("org.junit:junit-bom:5.13.4"))
        implementation("org.junit.jupiter:junit-jupiter")
        implementation("org.jetbrains.kotlin:kotlin-test")
      }

      targets {
        all {
          testTask.configure {
            useJUnitPlatform()
            testLogging {
              events(
                TestLogEvent.PASSED,
                TestLogEvent.FAILED,
                TestLogEvent.SKIPPED,
                TestLogEvent.STANDARD_OUT,
                TestLogEvent.STANDARD_ERROR,
              )
              exceptionFormat = TestExceptionFormat.FULL
              showStandardStreams = true
              showExceptions = true
              showCauses = true
              showStackTraces = true
            }
          }
        }
      }
    }
  }
}

tasks.register("openTestReport") {
  onlyIf { System.getenv("CI").isNullOrEmpty() }

  doLast {
    val report = layout.buildDirectory.file("reports/tests/test/index.html").get().asFile
    if (!report.exists()) {
      println("Test report not found at: ${report.absolutePath}")
      return@doLast
    }
    val os = System.getProperty("os.name").lowercase()
    println("Opening test report: ${report.absolutePath}")
    if (os.contains("mac")) {
      exec { commandLine("open", report.absolutePath) }
    } else if (os.contains("win")) {
      exec { commandLine("cmd", "/c", "start", report.absolutePath) }
    } else {
      // Linux/WSL
      exec { commandLine("xdg-open", report.absolutePath) }
    }
  }
}

tasks.named<Test>("test") {
  finalizedBy("openTestReport")
  useJUnitPlatform()
  finalizedBy(tasks.named("jacocoTestReport"))
}

tasks.named<JacocoReport>("jacocoTestReport") {
    dependsOn(tasks.test)

    classDirectories.setFrom(
        files(layout.buildDirectory.dir("classes/kotlin/main"))
    )
    sourceDirectories.setFrom(files("src/main/kotlin"))
    executionData.setFrom(files(layout.buildDirectory.file("jacoco/test.exec")))

    reports {
        xml.required.set(true)    // for CI tools
        html.required.set(true)   // for humans
    }
}


ktlint {
  filter {
    include("**/src/**/*.kt")
    exclude("**/build/**")
    exclude("**/*.kts")
  }
}


// macOS automatically creates hidden "._*" files on external drives (AppleDouble files).
// They are metadata/resource fork files that are useless for source control and can
// safely be removed.
val isMacOs =
  System.getProperty("os.name")
    ?.lowercase(Locale.getDefault())
    ?.contains("mac") == true

val dotCleanBuild by tasks.registering {
  onlyIf { isMacOs }
  description = "Clean macOS metadata files inside the build directory (safe)."

  doLast {
    val buildPath = layout.buildDirectory.get().asFile.absolutePath

    exec {
      commandLine("bash", "-lc", "command -v dot_clean >/dev/null 2>&1 && dot_clean -m '$buildPath' || true")
      isIgnoreExitValue = true
    }
    delete(
      fileTree(layout.buildDirectory) {
        include("**/.DS_Store", "**/._*")
      },
    )
  }
}

tasks.named("clean") {
  dependsOn(dotCleanBuild)
}

tasks.register("rebuild") {
  dependsOn("clean", "build")
  description = "Clean + build (macOS-safe)"
}
