// SPDX-FileCopyrightText: Copyright © 2026 Caleb Cushing
//
// SPDX-License-Identifier: MIT

plugins {
  application
}

group = "com.xenoterracide"
version = "0.0.0"

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

dependencies {
  implementation("info.picocli:picocli:4.7.7")
  annotationProcessor("info.picocli:picocli-codegen:4.7.7")

  testImplementation(platform("org.junit:junit-bom:5.12.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
  mainClass.set("com.xenoterracide.ghsecrets.GhSecretsCli")
}

tasks.test {
  useJUnitPlatform()
}
