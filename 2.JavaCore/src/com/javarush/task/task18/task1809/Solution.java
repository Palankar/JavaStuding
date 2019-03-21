package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());
        FileOutputStream outStream = new FileOutputStream(reader.readLine());

        if (inStream.available() > 0) {
            byte[] buffer = new byte[inStream.available()];
            inStream.read(buffer);

            for (int i = buffer.length - 1; i >= 0; i--) {
                outStream.write(buffer[i]);
            }
        }

        inStream.close();
        outStream.close();
    }
}
