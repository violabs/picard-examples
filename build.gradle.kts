import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
	kotlin("jvm") version "2.0.20"
	id("org.springdoc.openapi-gradle-plugin") version "1.9.0" apply false
	kotlin("plugin.spring") version "1.9.25" apply false
	id("org.springframework.boot") version "3.4.5" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
	apply(plugin = "kotlin")

	repositories {
		mavenCentral()
		maven { url = uri("https://www.jetbrains.com/intellij-repository/releases") }
	}
}

subprojects {
	dependencies {
		implementation(kotlin("stdlib"))
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		implementation("io.github.microutils:kotlin-logging:4.0.0-beta-2")

		implementation("com.fasterxml.jackson.core:jackson-databind:2.19.0")
		implementation("com.fasterxml.jackson.core:jackson-core:2.19.0")
		implementation("com.fasterxml.jackson.core:jackson-annotations:2.19.0")

		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
			jvmTarget.set(JvmTarget.JVM_21)
			languageVersion.set(KotlinVersion.KOTLIN_2_0)
		}
	}
}

project(":planet-tracker") {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "kotlin-spring")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springdoc.openapi-gradle-plugin")
}