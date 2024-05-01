package com.rabbitMQ.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/get")
    public String get(){
        System.out.println("asd");
        return "asd";
    }
}
