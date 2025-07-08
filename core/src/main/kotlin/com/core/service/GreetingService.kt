package com.core.service

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun getMessage(): String {
        return "Hello from Core module!"
    }

    fun getGreeting(name: String): String {
        return "Hello, $name!"
    }
}