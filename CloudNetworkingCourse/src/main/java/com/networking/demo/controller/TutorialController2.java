package com.networking.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorialController2 {
    @GetMapping("/tutorial2")
    public String getById() {
        System.out.println("Sringboot running");
        return "tutorial2";
    }
}