/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import UI.TreasurerLogin;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.mycompany.lato.model.Log;

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
    public static void test() {
        try {
            Firestore db = FirestoreClient.getFirestore();

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
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    };
    public static boolean addUser(String sid, String firstName, String lastName) {
        try{
            HashMap user = Get.getBySid(sid);
            return false;
        } catch(IndexOutOfBoundsException ex) {
            Firestore db = FirestoreClient.getFirestore();
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

            Map<String, Object> currentdata = Get.getByCollectionAndDocumentName("Statistics", "amount");
            int student = Integer.parseInt(currentdata.get("student")+"")+1;
            Update.updateStatistic(Double.parseDouble(currentdata.get("debt")+""), Double.parseDouble(currentdata.get("money")+""), student);
            new Log(TreasurerLogin.currentUser.getStudentId(), "Add user "+sid, "-",0.0);
            return true;
        }
    };

    public static void addLog(int counter, String name, String particular, String description, double amount, String timestamp) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            Map<String, Object> data = new HashMap<>();
            data.put("no", counter);
            data.put("name", name);
            data.put("particular", particular);
            data.put("description", description);
            data.put("amount", amount+"");
            data.put("createAt", timestamp);
            ApiFuture<DocumentReference> addedDocRef = db.collection("Log").add(data);
            System.out.println("Added document with ID: " + addedDocRef.get().getId());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }

//    public static void addStatistic(Double debt, Double money, Double student){
//        try {
//            Firestore db = FirestoreClient.getFirestore();
//
//            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//            Date date = new Date(System.currentTimeMillis());
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("debt", debt);
//            data.put("money", money);
//            data.put("student", student);
//            data.put("updateAt", formatter.format(date));
//            ApiFuture<DocumentReference> addedDocRef = db.collection("Sta").add(data);
//        }catch (InterruptedException | ExecutionException e){
//            System.out.println(e);
//        }
//    }

}
