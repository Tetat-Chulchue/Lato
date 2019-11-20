/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

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
    private Init init = new Init();
    private Firestore db;

    public Map<String, Object> getByCollectionAndDocumentName(String collectionName, String documentName){
        try {
            db = init.initializeApp();
            DocumentReference docRef = db.collection(collectionName).document(documentName);

            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                return document.getData();
            } else {
                System.out.println("No such document!");
                return null;
            }
        } catch (InterruptedException | ExecutionException | IOException e) {
            System.out.println(e + "Form: Get.java");
        }
        return null;
    }

    public ArrayList getAll() {
        try {
            ArrayList data = new ArrayList();
            HashMap object = new HashMap();
            db = init.initializeApp();
            ApiFuture<QuerySnapshot> future = db.collection("Table").get();
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
        } catch (IOException | InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        return null;
    }
}
