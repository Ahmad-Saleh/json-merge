package com.example.jsonmerge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public class JsonMergeTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(WRITE_DATES_AS_TIMESTAMPS);
        Person defaults = objectMapper.readValue(readFile("db.json"), Person.class);
        ObjectReader updater = objectMapper.readerForUpdating(defaults);
        Person merged = updater.readValue(readFile("updates.json"));
        objectMapper.writeValue(new File("result.json"), merged);
    }

    private static String readFile(String path) throws IOException {
        InputStream resourceAsStream = JsonMergeTest.class.getClassLoader().getResourceAsStream(path);
        return IOUtils.toString(resourceAsStream, "UTF-8");
    }
}
