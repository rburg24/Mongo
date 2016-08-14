package com.mongodb.fruits;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by ramon on 08/06/16.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setClassForTemplateLoading(SparkFormHandling.class, "/");

        Spark.get("/", (resquest, response) -> {

            try {
                Map<String, Object> map = new HashMap<>();
                map.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

                Template fpTemplate = cfg.getTemplate("fruitPicker.ftl");

                StringWriter sw = new StringWriter();

                fpTemplate.process(map, sw);

                return sw;
            } catch (Exception e) {
                halt(500);
                return null;
            }

        });


        Spark.post("/favorite_fruit", (request, response) -> {

            String fruit = request.queryParams("fruit");
            if (fruit == null) {
                return "Why don't you pick one?";
            } else {
                return "Your favorite fruit is: " + fruit;
            }

        });

    }
}
