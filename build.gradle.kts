plugins {
    kotlin("jvm") version "2.0.21"
}

group = "by.alerus"
version = "1.1"

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

tasks.jar {
    manifest.attributes["Main-Class"] = "MainKt"
    manifest.attributes["Implementation-Version"] = version
    manifest.attributes["Implementation-Title"] = "predictor_bot"

    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map { zipTree(it) }
    from(dependencies)

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
