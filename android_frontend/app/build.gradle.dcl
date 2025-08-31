androidApplication {
    namespace = "org.example.app"

    dependencies {
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
        // Ensure JUnit Jupiter engine is on the test runtime classpath for JUnit 5 test discovery
        runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    }
}
