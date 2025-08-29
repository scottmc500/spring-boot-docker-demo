package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/{name}")
    public String greetByName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
