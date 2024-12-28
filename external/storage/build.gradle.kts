dependencies {
    implementation(project(":common:logger"))

    // https://mvnrepository.com/artifact/com.querydsl/querydsl-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
}

tasks.withType<JavaExec> {
    systemProperty("module.name", project.name)
}