package com.abc.banana

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BananaApplication

fun main(args: Array<String>) {
	runApplication<BananaApplication>(*args)
}
