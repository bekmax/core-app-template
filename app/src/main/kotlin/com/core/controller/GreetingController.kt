package com.core.controller

import com.core.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GreetingController(val service: GreetingService) {

    @GetMapping("/message")
    fun getMessage(): String {
        return service.getMessage()
    }

    @GetMapping("/greeting/{name}")
    fun getGreeting(@PathVariable name: String): String {
        return service.getGreeting(name)
    }
}