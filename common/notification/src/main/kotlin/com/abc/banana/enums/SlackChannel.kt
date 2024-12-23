package com.abc.banana.enums

enum class SlackChannel(
    val channelId: String,
    val username: String? = null,
): Channel {
    // 공통 오류 채널
    COMMON_ERROR("C086AHRKECU", "공통 오류")
}