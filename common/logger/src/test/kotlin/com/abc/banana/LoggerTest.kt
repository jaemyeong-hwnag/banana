package com.abc.banana

import com.abc.banana.util.logger
import org.junit.jupiter.api.Test

class LoggerTest {
    @Test
    fun `로깅 테스트`() {
        logger().debug("Hello, World!")
        logger().debug("Hello, World!")
        logger().info("Hello, World!")
        logger().warn("Hello, World!")
        logger().error("Hello, World!")
    }
}