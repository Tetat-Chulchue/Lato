package com.mycompany.lato.model;

import com.mycompany.lato.query.Post;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String name;
    private String particular;
    private String description;
    private double amount;
    private String timestamp;

    public Log(String name, String particular, String description, double amount) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.name = name;
        this.particular = particular;
        this.description = description;
        this.amount = amount;
        this.timestamp = formatter.format(new Date(System.currentTimeMillis()));
        Post.addLog(name, particular, description, amount, timestamp);
    }

    public String getName() {
        return name;
    }

    public String getParticular() {
        return particular;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
