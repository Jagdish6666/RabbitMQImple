package com.example.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageid(UUID.randomUUID().toString());
        message.setMessgaeDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);

        return "messagePublished";
    }
}