package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

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

        TreeSet<String> finalSet = new TreeSet<>();
        double maxValue = Integer.MIN_VALUE;
        for (String str : map.keySet()) {
            if (map.get(str) > maxValue)
                maxValue = map.get(str);
        }
        for (String s : map.keySet()) {
            if (map.get(s).equals(maxValue))
                finalSet.add(s);
        }
        for (String s : finalSet) {
            System.out.println(s);
        }

    }
}
