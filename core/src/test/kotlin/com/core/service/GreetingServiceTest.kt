package com.core.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.TestPropertySource

@Configuration
@ComponentScan("com.core")
class TestConfiguration

@SpringBootTest(classes = [TestConfiguration::class])
@TestPropertySource(properties = ["spring.main.allow-bean-definition-overriding=true"])
class GreetingServiceTest {

    @Autowired
    private lateinit var service: GreetingService

    @Test
    fun `should return default message`() {
        val result = service.getMessage()
        assertEquals("Hello from Core module!", result)
    }

    @Test
    fun `should return personalized greeting`() {
        val result = service.getGreeting("Kotlin")
        assertEquals("Hello, Kotlin!", result)
    }
}