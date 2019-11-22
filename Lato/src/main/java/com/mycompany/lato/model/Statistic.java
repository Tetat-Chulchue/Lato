package com.mycompany.lato.model;

import com.mycompany.lato.query.Update;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Statistic {
    private double debt;
    private double money;
    private double student;
    private String timestamp;

    public Statistic(double debt, double money, int student) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.debt = debt;
        this.money = money;
        this.student = student;
        this.timestamp = formatter.format(new Date(System.currentTimeMillis()));
        Update.updateStatistic(debt, money, student);
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
