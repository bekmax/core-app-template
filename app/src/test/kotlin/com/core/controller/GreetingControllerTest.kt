package com.core.controller

import com.core.service.GreetingService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@TestConfiguration
class TestServiceConfig {
    @Bean
    @Primary
    fun greetingService(): GreetingService {
        return GreetingService()
    }
}

@SpringBootTest
@Import(TestServiceConfig::class)
@AutoConfigureMockMvc
@WebAppConfiguration
class GreetingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return message from service`() {
        mockMvc.get("/api/message") {
        }.andExpect {
            status { isOk() }
            content { string("Hello from Core module!") }
        }
    }

    @Test
    fun `should return personalized greeting`() {
        mockMvc.get("/api/greeting/World") {
        }.andExpect {
            status { isOk() }
            content { string("Hello, World!") }
        }
    }

    @Test
    fun `should handle greeting with different names`() {
        mockMvc.get("/api/greeting/John") {
        }.andExpect {
            status { isOk() }
            content { string("Hello, John!") }
        }
    }

    @Test
    fun `should handle greeting with special characters`() {
        mockMvc.get("/api/greeting/José") {
        }.andExpect {
            status { isOk() }
            content { string("Hello, José!") }
        }
    }
}