package com.networking.demo.model;
public class User {
    private Long id;
    private String email;

    // 构造函数、getter和setter
    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    // standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

