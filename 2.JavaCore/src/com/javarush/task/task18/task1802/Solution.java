package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static BufferedReader reader;

    public static void main(String[] args) throws Exception {
        int minByte = Integer.MAX_VALUE;
        int thisByte;

        reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());

        while (inStream.available() > 0) {
            if ((thisByte = inStream.read()) < minByte)
                minByte = thisByte;
        }

        reader.close();
        inStream.close();
        System.out.println(minByte);

    }
}
