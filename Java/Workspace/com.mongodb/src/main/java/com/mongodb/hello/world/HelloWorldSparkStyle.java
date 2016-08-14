package com.mongodb.hello.world;

import spark.*;
import spark.Response;

/**
 * Created by ramon on 08/04/16.
 */
public class HelloWorldSparkStyle {

    public static void main(String[] args) {
        Spark.get("/", (request, response) -> "Hello World From Spark");
    }
}
