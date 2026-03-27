package com.example.demo.model;

public class User {

    private String type;
    private String user;
    private String content;

    public User() {}

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }
}