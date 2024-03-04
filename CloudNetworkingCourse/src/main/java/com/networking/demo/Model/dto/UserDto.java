package com.networking.demo.Model.dto;

public class UserDto {
    private String username;
    private String password;

    // 默认构造函数
    public UserDto() {
    }

    // 带参数的构造函数
    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter和setter方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
