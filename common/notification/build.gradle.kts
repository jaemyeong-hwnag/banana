dependencies {
    implementation(project(":common:logger"))
    implementation(project(":external:api"))
}

tasks.withType<JavaExec> {
    systemProperty("module.name", project.name)
}