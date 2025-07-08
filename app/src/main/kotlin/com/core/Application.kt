package com.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication(scanBasePackages = ["com.core"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}