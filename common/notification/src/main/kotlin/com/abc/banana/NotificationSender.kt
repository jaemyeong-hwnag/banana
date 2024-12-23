package com.abc.banana

import com.abc.banana.enums.Channel

interface NotificationSender<C : Channel> {
    /**
     * 알림 발송
     *
     * @param channel 알림 발송 채널
     * @param message 알림 메시지
     */
    fun send(channel: C, message: String): Boolean

    /**
     * 서버 정보와 알림 발송
     *
     * @param channel 알림 발송 채널
     * @param message 알림 메시지
     */
    fun sendWithInfo(channel: C, message: String): Boolean
}