package com.rabbitMQ.demo;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitListener {
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "myQueue")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        System.out.println(message + " Processed");

        channel.basicAck(deliveryTag, false);

    }
}
