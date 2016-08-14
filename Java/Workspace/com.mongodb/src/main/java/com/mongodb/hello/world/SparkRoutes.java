package com.mongodb.hello.world;

import spark.Spark;

/**
 * Created by ramon on 08/06/16.
 */
public class SparkRoutes {
    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "Hello World\n");
        Spark.get("/test", (request, response) -> "This is a test page\n");
        Spark.get("/echo/:thing", (request, response) -> request.params(":thing"));

    }
}
