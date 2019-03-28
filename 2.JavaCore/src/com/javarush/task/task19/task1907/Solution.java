package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> allWords = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        int thisByte;
        String thisWord = "";
        while (fileReader.ready()) {
            thisByte = fileReader.read();

            if ((thisByte >= 65 && thisByte <= 90) || (thisByte >= 97 && thisByte <= 122)) {
                thisWord += (char) thisByte;
            } else {

                if (!allWords.containsKey(thisWord)) {
                    allWords.put(thisWord, 1);
                } else {
                    allWords.replace(thisWord, allWords.get(thisWord) + 1);
                }

                thisWord = "";
            }
        }
        fileReader.close();

        if (!allWords.containsKey(thisWord)) {
            allWords.put(thisWord, 1);
        } else {
            allWords.replace(thisWord, allWords.get(thisWord) + 1);
        }
        thisWord = "";


        if (allWords.containsKey("world"))
            System.out.println(allWords.get("world"));
        else
            System.out.println(0);
    }
}
