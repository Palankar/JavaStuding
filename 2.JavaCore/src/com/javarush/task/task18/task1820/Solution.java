package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String integer = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inStream = new FileInputStream(reader.readLine());
        FileOutputStream outStream = new FileOutputStream(reader.readLine());

        while (inStream.available() > 0) {
            char part;

            if ((part = (char)inStream.read()) != ' ' && inStream.available() > 0) {
                integer += part;
            } else if (inStream.available() > 0){
                integer = Math.round(Double.parseDouble(integer)) + " ";
                outStream.write(integer.getBytes());
                integer = "";
            } else {
                integer += part;
                integer = String.valueOf(Math.round(Double.parseDouble(integer)));
                outStream.write(integer.getBytes());
            }
        }
        inStream.close();
        outStream.close();
    }
}
