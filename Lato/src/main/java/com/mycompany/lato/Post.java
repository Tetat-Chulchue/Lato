/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato;

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
        Firestore db = gg.test();
        
        DocumentReference docRef = db.collection("users").document("alovelace3");
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1815);
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
    };
}
