package com.abc.banana

import com.abc.banana.util.logger
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest

@SpringBootApplication
class ApplicationTests {

    @Test
    fun contextLoads() {
        val moduleName = System.getProperty("module.name") ?: "UnknownModule"
        logger().debug("$moduleName TEST START")
    }

}