package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        String fileName = "";

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                fileName = reader.readLine();
                new FileInputStream(fileName).close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
    }
}
