/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Get {

    public Map<String, Object> test(String collectionName, String documentName) throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.test();

        DocumentReference docRef = db.collection(collectionName).document(documentName);

        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
            return document.getData();
        } else {
            System.out.println("No such document!");
        }
        return null;
    }
;
}
