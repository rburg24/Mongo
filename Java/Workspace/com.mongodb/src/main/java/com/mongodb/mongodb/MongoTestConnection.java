package com.mongodb.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

/**
 * Created by ramon on 08/14/16.
 */
public class MongoTestConnection {

    public static void main(String[] args) {

        MongoClientOptions mco = MongoClientOptions.builder().connectionsPerHost(100).build();

        MongoClient client = new MongoClient(new ServerAddress(), mco);

        MongoDatabase database = client.getDatabase("w2local").withReadPreference(ReadPreference.secondary());

        MongoCollection<BsonDocument> collection = database.getCollection("moviesScratch", BsonDocument.class);

        System.out.println(collection.count());

    }

}
