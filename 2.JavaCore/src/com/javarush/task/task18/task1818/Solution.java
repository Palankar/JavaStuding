package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream firstFileStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream secondFileStream = new FileInputStream(reader.readLine());
        FileInputStream thirdFileStream = new FileInputStream(reader.readLine());

        reader.close();

        while (secondFileStream.available() > 0)
            firstFileStream.write(secondFileStream.read());


        while (thirdFileStream.available() > 0)
            firstFileStream.write(thirdFileStream.read());

        firstFileStream.close();
        secondFileStream.close();
        thirdFileStream.close();
    }
}
