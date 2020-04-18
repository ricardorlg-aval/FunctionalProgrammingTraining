plugins {
    kotlin("jvm") version "1.3.72"
}

group = "org.personal"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.2")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.0.250-SNAPSHOT")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.1.0.250-SNAPSHOT")
    testImplementation("io.kotest:kotest-runner-console-jvm:4.1.0.250-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf(
            "-Xuse-experimental=kotlin.time.ExperimentalTime",
            "-Xuse-experimental=kotlin.ExperimentalStdlibApi"
        )
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf(
            "-Xuse-experimental=kotlin.time.ExperimentalTime"
        )
    }

    test {
        useJUnitPlatform()
    }
}