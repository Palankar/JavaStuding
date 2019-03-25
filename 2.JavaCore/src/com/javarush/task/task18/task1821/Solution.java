package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> symbols = new TreeMap<>();    //Потому что сортирует ключи по-умолчанию в порядке возрастания
        FileInputStream inStream = new FileInputStream(args[0]);

        int key;
        while (inStream.available() > 0) {
            if (!symbols.containsKey((key = inStream.read())))
                symbols.put(key, 1);
            else
                symbols.replace(key, symbols.get(key) + 1);
        }

        for (Integer integer : symbols.keySet()) {
            System.out.println((char)integer.byteValue() + " " + symbols.get(integer));
        }

        inStream.close();

    }
}
