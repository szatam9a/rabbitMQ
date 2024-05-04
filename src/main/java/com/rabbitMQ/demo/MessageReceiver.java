package com.rabbitMQ.demo;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MessageReceiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

    public CountDownLatch getLatch() {
        return latch;
    }


}
