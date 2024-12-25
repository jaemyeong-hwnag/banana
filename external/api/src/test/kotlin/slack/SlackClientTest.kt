package slack

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SlackClient::class])
class SlackClientTest(
    @Autowired private val slackClient: SlackClient,
) {
    @Test
    fun `메세지 발송`() {
        slackClient.publishMessage("C086AHRKECU", "안녕하세요 이름입니다.", "사용자 이름")
    }
}