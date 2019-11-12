/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lato;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author TanawatChanhom
 */
public class Delete {
    public void test() throws IOException, InterruptedException, ExecutionException {
        Init gg = new Init();
        Firestore db = gg.initializeApp();
        
        ApiFuture<WriteResult> writeResult = db.collection("users").document("alovelace3").delete();
        // ...
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }
}
