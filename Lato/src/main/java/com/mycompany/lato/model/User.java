package com.mycompany.lato.model;

public class User {
    private String username;
    private  String password;
    private Double debt;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.debt = 0.0;
    }

    public User(String username, String password, Double debt) {
        this.username = username;
        this.password = password;
        this.debt = debt;
    }

}
