package com.networking.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.networking.demo.service.UserService;
import com.networking.demo.Model.dto.UserDto;
import com.networking.demo.Model.entity.User;


@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public String registerUser(@RequestBody UserDto userDto) {
//
//        // 调用服务层注册新用户
//        User user = userService.registerNewUserAccount(userDto);
//        // 注册成功后的处理，这里只是简单返回一个字符串消息
//        return "redirect:/login";
//        //return ResponseEntity.ok("User registered successfully with username: " + user.getUsername());
//
//    }


//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody UserDto user) {
//        try {
//            User registeredUser = userService.registerNewUserAccount(user);
//            return ResponseEntity.ok("User registered successfully: " + registeredUser.getUsername());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        userService.registerNewUserAccount(user);
//        return "redirect:/login";
//    }

    // 假设登录逻辑由Spring Security处理，这里只是简单地返回登录页面
    @GetMapping("/login")
    public String login() {
        return "login"; // 实际中，应重定向到登录页面
    }

    // 如果需要，可以添加更多的路由处理方法，如登录、更新用户信息等
}
