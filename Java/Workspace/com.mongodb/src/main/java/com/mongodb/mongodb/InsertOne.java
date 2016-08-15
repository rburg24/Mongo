package com.mongodb.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.mongodb.util.PrintJson;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ramon on 08/14/16.
 */
public class InsertOne {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("w2local");
        MongoCollection<Document> collection = database.getCollection("insertTestTest");

        collection.drop();

        Document smith = new Document();
        smith.append("name", "Smith");
        smith.append("age", 38);
        smith.append("profession", "programmer");
        smith.remove("age");
        collection.insertOne(smith);
        smith.remove("age");

        Document jones = new Document();
        jones.append("name", "Jones");
        jones.append("age", 30);
        jones.append("profession", "doctor");

        collection.insertOne(jones);
        //collection.insertMany(Arrays.asList(smith,jones));
        System.out.println("------------------------------------------------------------");

    }
}
