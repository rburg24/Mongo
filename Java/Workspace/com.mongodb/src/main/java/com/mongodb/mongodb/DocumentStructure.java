package com.mongodb.mongodb;

import com.mongodb.mongodb.util.PrintJson;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by ramon on 08/14/16.
 */
public class DocumentStructure {
    public static void main(String[] args) {
        Document document =new Document();
        document.append("str", "Hello Mongo")
                .append("int", 42)
                .append("l", 1L)
                .append("double", 1.1)
                .append("b", false)
                .append("date", new Date())
                .append("objectId", new ObjectId())
                .append("null", null)
                .append("embeddedDoc", new Document("x",0))
                .append("list", Arrays.asList(1,2,3,4,5));

        String documentStr = document.getString("str");
        System.out.println(documentStr);
        Integer documentInt = document.getInteger("int");
        System.out.println(documentInt);

        PrintJson.execute(document);
    }

}
