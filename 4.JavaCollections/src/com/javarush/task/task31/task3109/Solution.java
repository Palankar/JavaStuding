package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws Exception {
        Properties property = new Properties();

        try {
            if (fileName.endsWith(".xml"))
                property.loadFromXML(new FileInputStream(fileName));
            else
                property.load(new FileInputStream(fileName));
        } catch (Exception e) {}
        return property;
    }
}
