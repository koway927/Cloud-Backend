package com.networking.demo.controller.unused_controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorialController {
    @GetMapping("/tutorial")
    public String getById() {
        System.out.println("Sringboot running");
        return "tutorial";
        //commit today 4.6
    }
}
