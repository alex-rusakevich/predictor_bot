plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        setUrl("https://jitpack.io")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.2.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.0")
}

tasks.test {
    useJUnitPlatform()
}