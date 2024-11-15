package com.john.titanic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TitanicApiApplication

fun main(args: Array<String>) {
	runApplication<TitanicApiApplication>(*args)
}
