plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.kapt") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.3.4"
}

version = "0.1"
group = "com.example"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}

dependencies {
    implementation("io.micronaut:micronaut-validation")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut:micronaut-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.neo4j:micronaut-neo4j-bolt")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    testRuntimeOnly("org.neo4j.test:neo4j-harness")
}


application {
    mainClass.set("com.example.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }


}
