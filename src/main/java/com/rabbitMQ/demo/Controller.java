package com.rabbitMQ.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private RabbitTemplate rabbitTemplate;

    public Controller(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/send")
    public String sendMsg(@RequestParam String topic, @RequestParam String msg){
        System.out.println(msg);
        rabbitTemplate.convertAndSend("",msg);
        return "asd";
    }
}
