package com.example.helloworld.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRepository {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
