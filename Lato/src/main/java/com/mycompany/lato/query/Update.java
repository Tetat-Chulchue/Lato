/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato.query;

import UI.TreasurerLogin;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mycompany.lato.model.Log;

import java.util.Date;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
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

    public static void updateStatistic(Double debt, Double money, int student) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            Map<String, Object> data = new HashMap<>();
            data.put("debt", debt);
            data.put("money", money);
            data.put("student", student);
            data.put("updateAt", formatter.format(date));
            ApiFuture<WriteResult> writeResult = db.collection("Statistics").document("amount").set(data, SetOptions.merge());

            System.out.println("Update time : " + writeResult.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }

    public static boolean updateUser(String sid, String firstName, String lastName) {
            try {
                if (!(sid.equals("") || firstName.equals("") || lastName.equals("")) && sid.length() == 8 && Integer.parseInt(sid) > 0){
                    HashMap user = Get.getBySid(sid);
                    Firestore db = FirestoreClient.getFirestore();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());

                    Map<String, Object> data = new HashMap<>();
                    data.put("firstName", firstName);
                    data.put("lastName", lastName);
                    data.put("updateAt", formatter.format(date));
                    ApiFuture<WriteResult> writeResult = db.collection("Users").document((String) user.get("uuid")).set(data, SetOptions.merge());
                    System.out.println("Update time : " + writeResult.get().getUpdateTime());
                    new Log(TreasurerLogin.currentUser.getStudentId(), "Update user " + sid, "-", 0.0);
                    return true;
                } else return false;
            } catch (IndexOutOfBoundsException | InterruptedException | ExecutionException | NumberFormatException e) {
                System.out.println(e);
                return false;
            }

    }
}
