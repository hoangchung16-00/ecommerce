package com.example.eCommerce.models;

public class User {
    private Long id;
    private String username;
    private String password;
    private Boolean isAmin;

    public User(Long id, String username, String password, Boolean isAmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAmin = isAmin;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isAmin() {
        return isAmin;
    }
}
