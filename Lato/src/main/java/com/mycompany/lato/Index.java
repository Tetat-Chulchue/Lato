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
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Index {

    private Map ghy;

    public void test() throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.test();

        ApiFuture<QuerySnapshot> future = db.collection("users").whereEqualTo("born", 1815).get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        documents.forEach((document) -> {
            System.out.println(document.getId() + " => " + document.getData());
        });
    }
}
