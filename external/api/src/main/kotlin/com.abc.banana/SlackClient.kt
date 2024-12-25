package com.abc.banana

import com.abc.banana.util.logger
import com.slack.api.Slack
import com.slack.api.methods.SlackApiException
import com.slack.api.methods.request.chat.ChatPostMessageRequest.ChatPostMessageRequestBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.IOException


@Component
/**
 * @see <a href="https://api.slack.com/messaging/sending#impersonation">https://api.slack.com/messaging/sending#impersonation</a>
 */
class SlackClient(
    @Value("\${slack.token}")
    private val slackToken: String,
) {
    /**
     * 메세지 발송
     *
     * @todo 이모지 등 추가 작업 필요
     *
     * @param channelId 채널 ID
     * @param text 메세지 텍스트
     * @param username 사용자 이름
     * @return 메세지 전송 결과
     * @throws IOException
     * @throws SlackApiException
     */
    fun publishMessage(channelId: String, text: String, username: String?): Boolean {
        logger().debug("slack 발송 - channel: {}, text: {}", channelId, text)
        // you can get this instance via ctx.client() in a Bolt app
        val client = Slack.getInstance().methods()
        // Call the chat.postMessage method using the built-in WebClient
        val result = client.chatPostMessage { r: ChatPostMessageRequestBuilder ->
            r // The token you used to initialize your app
                .token(slackToken)
                .channel(channelId)
                .text(text)
                .apply { username?.let { this.username(username) } }
        }

        // 발송 성공 여부 로그
        if (!result.isOk) {
            logger().error("slack 발송 실패 {}", result.error)
        } else {
            logger().debug("slack 발송 성공")
        }

        return result.isOk
    }
}