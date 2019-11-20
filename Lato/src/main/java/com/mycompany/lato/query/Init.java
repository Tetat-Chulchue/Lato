/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.*;

/**
 *
 * @author Tanawat Chanhom
 */
public class Init {
    public Firestore initializeApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccount.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://lato-744d4.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();
        return db;
    };
}
