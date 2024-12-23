dependencies {
    implementation(project(":common:logger"))
    implementation(project(":external"))
}

tasks.withType<JavaExec> {
    systemProperty("module.name", project.name)
}