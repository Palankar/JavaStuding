package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());

        if(inStream.available() > 0) {
            byte[] buffer = new byte[inStream.available()];
            inStream.read(buffer);

            for (byte b : buffer) {
                if (b == 44)    //ASCII код символа ',' ( можно найти онлайн по сайту: https://decodeit.ru/ascii )
                    count++;
            }
        }

        System.out.println(count);

        reader.close();
        inStream.close();
    }
}
