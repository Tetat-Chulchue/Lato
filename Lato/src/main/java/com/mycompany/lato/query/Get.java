/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Get {


    public static Map<String, Object> getByCollectionAndDocumentName(String collectionName, String documentName){
        try {
            Firestore db = FirestoreClient.getFirestore();
            DocumentReference docRef = db.collection(collectionName).document(documentName);

            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                return document.getData();
            } else {
                System.out.println("No such document!");
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e + "Form: Get.java");
        }
        return null;
    }

    public static ArrayList getAll() {
        try {
            Firestore db = FirestoreClient.getFirestore();
            ArrayList data = new ArrayList();
            HashMap object = new HashMap();
            ApiFuture<QuerySnapshot> future = db.collection("Users").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                object.put("uuid", document.getId());
                object.put("SID", document.getData().get("SID"));
                object.put("firstName", document.getData().get("firstName"));
                object.put("lastName", document.getData().get("lastName"));
                object.put("amount", document.getData().get("amount"));
                object.put("createAt", document.getData().get("createAt"));
                object.put("updateAt", document.getData().get("updateAt"));
                data.add(object.toString());
            }
            return data;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        return null;
    }
    public static HashMap getBySid(String target) {
        try {
            ArrayList<HashMap> data = new ArrayList();
            HashMap object = new HashMap();
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> future = db.collection("Users").whereEqualTo("SID", target).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                object.put("uuid", document.getId());
                object.put("SID", document.getData().get("SID"));
                object.put("firstName", document.getData().get("firstName"));
                object.put("lastName", document.getData().get("lastName"));
                object.put("amount", document.getData().get("amount"));
                object.put("createAt", document.getData().get("createAt"));
                object.put("updateAt", document.getData().get("updateAt"));
                data.add(object);
            }
            return data.get(0);
        } catch (IndexOutOfBoundsException | InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        return null;
    }
}
