package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        String thisLine;
        int counter = 0;
        while (fileReader.ready()) {
            thisLine = fileReader.readLine();

            for (String word : thisLine.split(" ")) {
                if (words.contains(word)) counter++;
            }

            if (counter == 2) System.out.println(thisLine);
            counter = 0;
        }
        fileReader.close();
    }
}
