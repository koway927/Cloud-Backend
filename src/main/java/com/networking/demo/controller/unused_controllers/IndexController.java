package com.networking.demo.controller.unused_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {
    @GetMapping("/index")


    public String getById() {
        System.out.println("Sringboot running");
        return "index";
    }
}



