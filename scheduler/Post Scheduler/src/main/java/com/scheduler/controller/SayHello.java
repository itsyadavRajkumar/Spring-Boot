package com.scheduler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class SayHello {
    @PostMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello " + name + "\nHow are you!";
    }
}
