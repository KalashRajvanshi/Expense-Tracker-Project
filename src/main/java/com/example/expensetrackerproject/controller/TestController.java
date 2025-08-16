package com.example.expensetrackerproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String home() {
        return "Hello, Expense Tracker is running!";
    }
}