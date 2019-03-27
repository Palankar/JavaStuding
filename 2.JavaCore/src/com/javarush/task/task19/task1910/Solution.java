package com.javarush.task.task19.task1910;

/* 
Пунктуация
-->Регулярное выражение \p{Punct} указывает на все знаки пунктуации, в том числе и на символ переноса строки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        while (fileReader.ready()) {
            fileWriter.write(fileReader.readLine().replaceAll("[\\p{Punct}]", ""));
        }

        fileReader.close();
        fileWriter.close();
    }
}
