package com.mycompany.lato.model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mycompany.lato.query.Get;
import com.mycompany.lato.query.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Log {
    private String name;
    private String particular;
    private String description;
    private double amount;
    private String timestamp;
    private int no;

    public Log(String name, String particular, String description, double amount) {
        Firestore db = FirestoreClient.getFirestore();

        Get statisticData = new Get();
        Map<String, Object> data = statisticData.getByCollectionAndDocumentName("Statistics", "amount");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.no = Integer.parseInt(data.get("log").toString())+1;
        this.name = name;
        this.particular = particular;
        this.description = description;
        this.amount = amount;
        this.timestamp = formatter.format(new Date(System.currentTimeMillis()));
        Post.addLog(Integer.parseInt(data.get("log").toString())+1, name, particular, description, amount, timestamp);

        DocumentReference currentAmount = db.collection("Statistics").document("amount");
        ApiFuture<WriteResult> writeResult = currentAmount.update("log", Integer.parseInt(data.get("log").toString())+1);
    }

    public String getName() {
        return name;
    }

    public String getParticular() {
        return particular;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
