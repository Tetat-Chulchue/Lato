package com.mycompany.lato.model;

public class User {
    private Double debt;

    public User(String username, String password, Double debt) {
        this.debt = debt;
    }

    public void payDebt(float amount) {
        this.debt -= amount;
    }

    public void addDebt(float amount) {
        this.debt += amount;
    }

}
