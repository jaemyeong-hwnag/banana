import util.logger
import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ApplicationTests {

    @Test
    fun contextLoads() {
        val moduleName = System.getProperty("module.name") ?: "UnknownModule"
        logger().debug("$moduleName TEST START")
    }

}
