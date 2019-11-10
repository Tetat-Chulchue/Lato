package com.mycompany.lato.model;

public class User {
    private String name;
    private String lastname;
    private String id;
    private Double debt;

    public User(String name, String lastname, String id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.debt = 0.0;
    }

    public void payDebt(float amount) {
        this.debt -= amount;
    }

    public void addDebt(float amount) {
        this.debt += amount;
    }

}
