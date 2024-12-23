package com.abc.banana.enums

object SlackMessageStyle: MessageStyle {
    override fun String.bold(): String {
        return String.format("*%s*", this).trimIndent()
    }

    override fun String.codeLine(): String {
        return String.format("`%s`", this).trimIndent()
    }

    override fun String.codeBlock(): String {
        return String.format("```%s```", this).trimIndent()
    }

    override fun newLine(): String {
        return "\n"
    }
}
