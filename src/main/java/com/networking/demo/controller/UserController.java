package com.networking.demo.controller;

import com.networking.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
//we need to modify the domain in here.
@RestController
@RequestMapping("/api/users")
public class UserController {


    private final int test_variable = 2;

    private final UserService userService;
    @GetMapping("/testVariable")
    public int getTestVariable() {
        return test_variable;
    }


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 处理获取所有用户邮箱的请求
    @GetMapping("/emails")
    public List<String> getAllUserEmails() {
        return userService.getAllUsers().stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

}


