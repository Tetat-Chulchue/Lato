package com.mycompany.lato.control;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.mycompany.lato.model.HeadTreasurer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthController {
    public Boolean loginHandler(String email, String password) {
    String payload = "\"email=" + email + "&password=" + password + "\"";
    String command = "curl -X POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyCNnfqtppF_25UEmRc_ezyHX4IdyauoR0c -H 'Content-Type: application/json' --data "+payload;
    try {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine())!= null) {
            System.out.println(line);
        }
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
        }
        return null;
    }
}
