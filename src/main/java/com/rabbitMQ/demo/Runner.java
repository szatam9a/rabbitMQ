package com.rabbitMQ.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final MessageReceiver receiver;

    public Runner(MessageReceiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting");
        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName,"foo.bar.valami","Hey MR ,1");
        Thread.sleep(10000);
        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName,"foo.bar.valami","Hey MR,1 2");
        Thread.sleep(10000);
        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName,"foo.bar.valami","Hey MR, 123");
        Thread.sleep(10000);

    }
}
