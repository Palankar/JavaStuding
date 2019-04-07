package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);

        StringBuilder words = new StringBuilder();
        while (fileReader.ready()) {
            words.append((char)fileReader.read());
        }
        fileReader.close();

        String[] strings = words.toString().replaceAll(System.lineSeparator(), " ").split(" ");
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 6) finalString.append(strings[i] + ",");
        }
        fileWriter.write(finalString.toString().substring(0, finalString.length()-1));
        fileWriter.close();
    }
}
