package com.jss.rabbitPublisherProject

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitPublisherProjectApplication : CommandLineRunner {

    @Autowired
    private lateinit var rabbitTemplate: RabbitTemplate

    companion object {
        var exchange = "DirectExchange"
        var routing = "firstTopic"
        var message = SimpleMessage("Message from publisher", "Simple Description")
    }

    override fun run(vararg args: String?) {
        try {
            rabbitTemplate.convertAndSend(exchange, routing, message)
        } catch (exception: Exception) {
            println("Error on convert and send: ${exception.message}")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<RabbitPublisherProjectApplication>(*args)
}
