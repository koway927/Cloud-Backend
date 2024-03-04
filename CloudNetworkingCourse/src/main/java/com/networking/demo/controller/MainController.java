package com.networking.demo.controller;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import java.util.*;

@Controller
@SpringBootApplication
public class MainController {

    private Map<String, String> users = new HashMap<>(); // Username -> Password mapping

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username, @RequestParam String password) {
        if (users.containsKey(username)) {
            return "User already exists.";
        }
        users.put(username, password);
        return "Registration successful.";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "Login successful.";
        }
        return "Invalid username or password.";
    }
}
