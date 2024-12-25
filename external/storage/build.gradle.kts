dependencies {
    implementation(project(":common:logger"))
}

tasks.withType<JavaExec> {
    systemProperty("module.name", project.name)
}