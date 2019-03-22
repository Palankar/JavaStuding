package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int symbols = 0;
        int spaces = 0;

        FileInputStream inStream = new FileInputStream(args[0]);

        while (inStream.available() > 0) {
            if ((char)inStream.read() == ' ') {
                spaces++;
                symbols++;
            } else {
                symbols++;
            }
        }

        inStream.close();
        System.out.printf("%.2f", ((double)spaces/symbols*100));
    }
}
