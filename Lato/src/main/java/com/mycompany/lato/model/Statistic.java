package com.mycompany.lato.model;

public class Statistic {
    private double debt;
    private double money;
    private double student;

    public Statistic(double debt, double money, double student) {
        this.debt = debt;
        this.money = money;
        this.student = student;
    }

    public double getDebt() {
        return debt;
    }

    public double getMoney() {
        return money;
    }

    public double getStudent() {
        return student;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setStudent(double student) {
        this.student = student;
    }
}
