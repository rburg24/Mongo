package com.mongodb.hello.world;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.halt;

/**
 * Created by ramon on 08/04/16.
 */
public class HelloFreemarkerAndSpark {

    public static void main(String[] args) {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        Spark.get("/", (request, response) -> {

            StringWriter sw = new StringWriter();
            try {
                Template hTemplate = cfg.getTemplate("hello.ftl");
                Map<String, Object> hMap = new HashMap<>();
                hMap.put("name", "Freemarker");
                hTemplate.process(hMap, sw);

            } catch (Exception e) {
                halt(500);
                e.printStackTrace();
            }

            return sw;
        });


    }
}
