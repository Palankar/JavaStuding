package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String[] thisStrings;
        Integer integer;
        while (fileReader.ready()) {
            thisStrings = fileReader.readLine().split(" ");

            for (String string : thisStrings) {
                try {
                    integer = Integer.parseInt(string);
                    fileWriter.write(integer + " ");
                } catch (Exception e) {
                    continue;
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
