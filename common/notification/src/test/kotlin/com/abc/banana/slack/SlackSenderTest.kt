package com.abc.banana.slack

import com.abc.banana.NotificationSender
import slack.SlackClient
import com.abc.banana.enums.SlackChannel
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SlackSender::class, SlackClient::class])
class SlackSenderTest(
    @Autowired private val slackSender: NotificationSender<SlackChannel>,
) {
    @Test
    fun `슬랙 발송 테스트`() {
        slackSender.send(SlackChannel.COMMON_ERROR, "테스트 메세지")
    }
}