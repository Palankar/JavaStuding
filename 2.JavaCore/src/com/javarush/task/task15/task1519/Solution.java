package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String read;
        while (!(read = reader.readLine()).equals("exit")) {
            try {
                if (read.contains("."))
                    print(Double.valueOf(read));
                else if (Integer.parseInt(read) > 0 && Integer.parseInt(read) < 128)
                    print((short)Integer.parseInt(read));
                else if (Integer.parseInt(read) <= 0 || Integer.parseInt(read) >= 128)
                    print(Integer.parseInt(read));
            } catch (NumberFormatException e) {
                print(read);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
