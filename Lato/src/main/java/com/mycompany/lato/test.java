/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
/**
 *
 * @author Tanawat Chanhom
 */
public class test {
    FileInputStream serviceAccount = new FileInputStream("./lato-744d4-firebase-adminsdk-cjt1k-e7c29ad451.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    .setDatabaseUrl("https://lato-744d4.firebaseio.com")
    .build();

    FirebaseApp.initializeApp(options);
}
