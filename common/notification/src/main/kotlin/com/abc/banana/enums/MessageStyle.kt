package com.abc.banana.enums

interface MessageStyle {
    /**
     * 글씨 굵게
     */
    fun String.bold(): String

    /**
     * 코드 라인
     */
    fun String.codeLine(): String

    /**
     * 코드 블록
     */
    fun String.codeBlock(): String

    /**
     * 새 줄
     */
    fun newLine(): String
}