package com.abc.banana.slack

import com.abc.banana.NotificationSender
import slack.SlackClient
import com.abc.banana.enums.SlackChannel
import util.logger
import org.springframework.stereotype.Component

@Component
class SlackSender(
    private val slackClient: SlackClient,
): NotificationSender<SlackChannel> {
    override fun send(channel: SlackChannel, message: String): Boolean {
        return runCatching {
            logger().debug("slack 발송 - channel: {}, message: {}", channel, message)
            slackClient.publishMessage(channel.channelId, message, channel.username)
        }.onFailure {
            logger().error("slack 발송 오류 발생", it)
        }.isSuccess
    }

    override fun sendWithInfo(channel: SlackChannel, message: String): Boolean {
        return true
    }
}