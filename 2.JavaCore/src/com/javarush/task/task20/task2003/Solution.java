package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();


    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        props.putAll(Solution.properties);
        props.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        props.load(inputStream);
        for (Object o : props.keySet()) {
            properties.put(o.toString(), props.getProperty(o.toString()));
        }
    }

    public static void main(String[] args) {

    }
}
