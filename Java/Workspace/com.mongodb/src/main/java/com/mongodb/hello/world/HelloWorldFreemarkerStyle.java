package com.mongodb.hello.world;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ramon on 08/04/16.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {
            Template hTemplate = cfg.getTemplate("hello.ftl");
            StringWriter sw = new StringWriter();
            Map<String, Object> hMap = new HashMap<>();
            hMap.put("name", "Freemarker");
            hTemplate.process(hMap, sw);
            System.out.println(sw);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
