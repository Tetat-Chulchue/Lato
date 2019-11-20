/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Update {

    public void test() throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.initializeApp();

        Map<String, Object> update = new HashMap<>();
        update.put("born", 1830);

        ApiFuture<WriteResult> writeResult
                = db
                    .collection("users")
                    .document("alovelace2")
                    .set(update, SetOptions.merge());
        
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
}
