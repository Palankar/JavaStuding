package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static BufferedReader reader;
    public static void main(String[] args) throws Exception {
        int thisByte;
        //Потому что TreeSet автоматически сортирует ключи по возрастанию
        TreeSet<Integer> bytesMap = new TreeSet<>();

        reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());

        while (inStream.available() > 0) {
            if (!bytesMap.contains((thisByte = inStream.read())))
                bytesMap.add(thisByte);
        }

        //вывод всех уникальных байтов в порядке по возрастанию, заданным коллекцией TreeSet
        for (Integer integer : bytesMap) {
            System.out.print(integer + " ");
        }

        reader.close();
        inStream.close();
    }
}
