package com.networking.demo.service;

import com.networking.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    // 一个假的用户列表代替数据库
    private List<User> users = Arrays.asList(
            new User(1L, "user1@example.com"),
            new User(2L, "user2@example.com"),
            new User(3L, "user3@example.com")
    );

    // 返回所有用户的方法
    public List<User> getAllUsers() {
        return users;
    }
}
