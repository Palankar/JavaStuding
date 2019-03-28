package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        while (fileReader.ready()) {
            String thisString = fileReader.readLine();
            String thisKey = thisString.substring(0, thisString.indexOf(" "));
            Double thisValue = Double.parseDouble(thisString.substring(thisString.indexOf(" ")));

            if (!map.containsKey(thisKey)) {
                map.put(thisKey, thisValue);
            } else {
                map.replace(thisKey, map.get(thisKey) + thisValue);
            }
        }
        fileReader.close();

        for (String str : map.keySet()) {
            System.out.println(str + " " + map.get(str));
        }
    }
}
