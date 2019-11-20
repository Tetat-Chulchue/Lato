package com.mycompany.lato.model;

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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
