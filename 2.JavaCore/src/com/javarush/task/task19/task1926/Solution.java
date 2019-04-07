package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        ArrayList<StringBuilder> lines = new ArrayList<>();
        while (fileReader.ready()) {
            lines.add(new StringBuilder(fileReader.readLine()));
        }
        fileReader.close();

        for (StringBuilder line : lines) {
            System.out.println(line.reverse());
        }
    }
}
