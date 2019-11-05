package com.mycompany.lato.model;

public class Debtor implements Authentication{
    private String username;
    private  String password;
    private Double debt;
    public Debtor(String username, String password) {
        this.username = username;
        this.password = password;
        this.debt = 0.0;
    }

    public Debtor(String username, String password, Double debt) {
        this.username = username;
        this.password = password;
        this.debt = debt;
    }

    @Override
    public Boolean login() {
        return null;
    }

    @Override
    public Boolean logout() {
        return null;
    }
}
