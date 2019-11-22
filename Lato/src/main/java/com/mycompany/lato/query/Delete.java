///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.mycompany.lato.query;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
//
///**
// *
// * @author TanawatChanhom
// */
public class Delete {
//    public void test() throws InterruptedException, ExecutionException {
//        Firestore db = FirestoreClient.getFirestore();
//
//        ApiFuture<WriteResult> writeResult = db.collection("users").document("alovelace3").delete();
//        // ...
//        System.out.println("Update time : " + writeResult.get().getUpdateTime());
//    }
    public static boolean deleteUser(String sid) throws InterruptedException, ExecutionException {
        try {
            Firestore db = FirestoreClient.getFirestore();
            HashMap user = Get.getBySid(sid);
            ApiFuture<WriteResult> writeResult = db.collection("users").document((String)user.get("uuid")).delete();
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            return true;
        } catch (IndexOutOfBoundsException ex){
            return false;
        }
    }
}
