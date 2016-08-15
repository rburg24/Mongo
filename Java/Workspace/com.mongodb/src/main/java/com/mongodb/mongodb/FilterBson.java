package com.mongodb.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.mongodb.util.PrintJson;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ramon on 08/14/16.
 */
public class FilterBson {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("w2local");
        MongoCollection<Document> collection = database.getCollection("filters");

        collection.drop();

        for (int i =0; i < 50; i++){
            collection.insertOne(new Document().append("x", new Random().nextInt(2))
                                               .append("y", new Random().nextInt(200)));
        }

        //Bson filter = new Document("x", 0);
        //Bson filter = Filters.and(Filters.eq("x", 0), Filters.gt("y", 10));

        Bson sort = Sorts.orderBy(Sorts.ascending("x"), Sorts.descending("y"));

        //Bson projection = new Document("x", 0);
        //Bson projection = Projections.fields(Projections.include("x"), Projections.excludeId());
        Bson projection = Projections.fields(Projections.excludeId());

        List<Document> all = collection.find()
                                       .projection(projection)
                                       .sort(sort)
                                        .skip(20)
                                        .limit(22)
                                       .into(new ArrayList<>());

        for (Document cur: all){
            PrintJson.execute(cur);
        }

        long count = collection.count();

        System.out.println();
        System.out.println(count);

    }


}
