/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Post {
    public static void test() throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.initializeApp();

        for (int i = 1; i < 50; i++) {

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            Map<String, Object> data = new HashMap<>();
            data.put("SID", 61070+String.format("%03d", i));
            data.put("firstName", "Ada");
            data.put("lastName", "Lovelace");
            data.put("amount", 0.0);
            data.put("createAt", formatter.format(date));
            data.put("updateAt", formatter.format(date));
            ApiFuture<DocumentReference> addedDocRef = db.collection("Users").add(data);
            System.out.println("Added document with ID: " + addedDocRef.get().getId());
        }
    };
    public static boolean addUser(String sid, String firstName, String lastName) throws IOException, InterruptedException, ExecutionException {
        try{
            HashMap user = Get.getBySid(sid);
            return false;
        }catch(IndexOutOfBoundsException ex){
            Init gg = new Init();
            Firestore db = gg.initializeApp();

            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            Map<String, Object> data = new HashMap<>();
            data.put("SID", sid);
            data.put("firstName", firstName);
            data.put("lastName", lastName);
            data.put("amount", 0.0);
            data.put("createAt", formatter.format(date));
            data.put("updateAt", formatter.format(date));
            ApiFuture<DocumentReference> addedDocRef = db.collection("Users").add(data);
            return true;
        }
    };
}
