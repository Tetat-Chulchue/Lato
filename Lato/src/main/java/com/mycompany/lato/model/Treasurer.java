package com.mycompany.lato.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Treasurer {
    protected String name;
    protected String lastname;
    protected String studentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static String login(String email, String password) {
        String payload = "\"email=" + email + "&password=" + password + "\"";
        System.out.println(payload);
        String command = "curl -X POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCNnfqtppF_25UEmRc_ezyHX4IdyauoR0c -H 'Content-Type: application/json' --data "+payload;
        System.out.println(command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            Gson gson = new Gson();
            Response res = gson.fromJson(reader, Response.class);
            return res.getEmail();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error";
        }

    };
}
