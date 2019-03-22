package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        int counter = 0;

        FileInputStream inputStream = new FileInputStream(args[0]);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        inputStream.close();

        //ASCII коды английских букв от 65 до 90 - малые и от 97 до 122 - заглавные
        for (byte a : bytes) {
            if ((a >= 65 && a <= 90) || (a >= 97 && a <= 122)) { counter++;
            }
        }

        System.out.println(counter);
    }
}
