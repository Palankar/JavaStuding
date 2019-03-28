package com.javarush.task.task19.task1909;

/* 
Замена знаков
-->Метод newLine() из BufferedWriter ставит символ переноса, организуя следующую печать по write() на новой строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String thisLine;
        while (fileReader.ready()) {
            thisLine = fileReader.readLine().replaceAll("\\.", "!");
            fileWriter.write(thisLine);
            fileWriter.newLine();
        }

        fileReader.close();
        fileWriter.close();
    }
}
