/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Post {
    public void test() throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.initializeApp();

        for (int i = 1; i < 10; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("SID", 6107000+i);
            data.put("firstName", "Ada");
            data.put("lastName", "Lovelace");
            data.put("amount", 99999);
            data.put("createAt", "xx-xx-xxxx");
            data.put("updateAt", "xx-xx-xxxx");
            ApiFuture<DocumentReference> addedDocRef = db.collection("Table").add(data);
            System.out.println("Added document with ID: " + addedDocRef.get().getId());
        }
    };
}
