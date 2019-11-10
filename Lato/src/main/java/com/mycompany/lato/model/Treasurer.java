package com.mycompany.lato.model;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Treasurer {
    protected String name;
    protected String lastname;
    protected String studentId;

    public void login(String email, String password) {
        String payload = "\"email=" + email + "&password=" + password + "\"";
        System.out.println(payload);
        String command = "curl -X POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCNnfqtppF_25UEmRc_ezyHX4IdyauoR0c -H 'Content-Type: application/json' --data "+payload;
        System.out.println(command);
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine())!= null)
            {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    };
}
