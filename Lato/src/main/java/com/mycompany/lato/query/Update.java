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
import com.google.firebase.cloud.FirestoreClient;
import java.util.Date;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Update {

    public void test() throws IOException, InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> update = new HashMap<>();
        update.put("born", 1830);

        ApiFuture<WriteResult> writeResult
                = db
                    .collection("users")
                    .document("alovelace2")
                    .set(update, SetOptions.merge());

        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }

    public static void updateStatistic(Double debt, Double money, Double student) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            Map<String, Object> data = new HashMap<>();
            data.put("debt", debt);
            data.put("money", money);
            data.put("student", student);
            data.put("updateAt", formatter.format(date));
            ApiFuture<WriteResult> writeResult = db.collection("Statistics").document("Amount").set(data, SetOptions.merge());

            System.out.println("Update time : " + writeResult.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }
}
