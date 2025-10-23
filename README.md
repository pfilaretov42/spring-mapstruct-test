# spring-mapstruct-test

Test potential mapstruct pitfalls

## Java 25 (Liberica) and Kotlin compatibility

This project is configured to use JDK 25 via Gradle Toolchains:

- Java toolchain: 25
- Gradle wrapper: 8.14.3 (supports recent JDKs)
- Kotlin: 2.2.20
- JVM bytecode target: 24 (highest supported by Kotlin 2.2.20; Kotlin does not yet support target 25)
- Spring Boot: 3.5.6

Notes:
- Gradle Toolchains will auto‑download the required JDK if you don't have it locally (enabled in `gradle.properties`).
- If you prefer to use a local JDK, install Liberica JDK 25 and ensure `JAVA_HOME` points to it, or that it is detected by Gradle.

### How to build and test

- macOS/Linux: `./gradlew clean build`
- Windows: `gradlew.bat clean build`

If you run into any JDK detection issues, verify with:

- `./gradlew -v` to see the Java used by Gradle
- `./gradlew javaToolchains` to list detected and installed toolchains

