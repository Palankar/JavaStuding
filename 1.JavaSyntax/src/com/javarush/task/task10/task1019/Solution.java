package com.javarush.task.task10.task1019;


import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                if (name.length() != 0)
                    map.put(name, id);
                else {
                    printMap(map);
                    System.out.println(id);
                    break;
                }
            }
        }
        catch (NumberFormatException e) {
            printMap(map);
        }
    }

    public static void printMap(HashMap<String, Integer> map) {
        for (String s : map.keySet()) {
            System.out.println(map.get(s) + " " + s);
        }
    }
}
