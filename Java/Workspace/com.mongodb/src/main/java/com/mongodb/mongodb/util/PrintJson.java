package com.mongodb.mongodb.util;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

import java.io.StringWriter;

/**
 * Created by ramon on 08/14/16.
 */
public class PrintJson {


    public static void execute(Document doc){
        JsonWriter jw =new JsonWriter(new StringWriter(), new JsonWriterSettings(JsonMode.SHELL, true));
        new DocumentCodec().encode(jw, doc, EncoderContext.builder().isEncodingCollectibleDocument(true).build());

        System.out.println(jw.getWriter());
        System.out.flush();
    }

}
