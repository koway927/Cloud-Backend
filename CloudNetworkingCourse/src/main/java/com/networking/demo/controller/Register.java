package com.networking.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class Register {
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // 这里假设你有一个名为'register.html'的Thymeleaf模板
    }

}
