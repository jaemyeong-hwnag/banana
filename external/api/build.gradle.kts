dependencies {
    // https://mvnrepository.com/artifact/com.slack.api/slack-api-client
    implementation("com.slack.api:slack-api-client:1.44.2")

    implementation(project(":common:logger"))
}

tasks.withType<JavaExec> {
    systemProperty("module.name", project.name)
}