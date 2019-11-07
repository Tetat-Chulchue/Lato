package com.mycompany.lato.model;

import java.io.IOException;

public class Treasurer {
    protected String name;
    protected String lastname;
    protected String studentId;

    public void login(String email, String password) {
        String payload = "{\"email\":\"" + email + "\",\"" + "password\":" + password + "\"}";
        System.out.println(payload);
        String command = "curl -X POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=[AIzaSyCNnfqtppF_25UEmRc_ezyHX4IdyauoR0c] --data " + payload + "\"";
        try {
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

    };
}
