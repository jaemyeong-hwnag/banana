plugins {
    kotlin("jvm")
    kotlin("plugin.spring") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

val projectGroup: String by project
val applicationVersion: String by project

allprojects {
    group = projectGroup
    version = applicationVersion

    repositories {
        mavenCentral()
    }
}

subprojects {
	apply(plugin = "kotlin")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    kotlin {
        compilerOptions {
            freeCompilerArgs.addAll("-Xjsr305=strict")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}