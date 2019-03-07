package com.javarush.task.task15.task1517;

/* 
Статики и исключения
--> Суть в том, что в static блоке нельзя просто взять и
выкинуть исключение. Однако, это можно сделать при помощи
условия.
Ну а еще тут работает try-catch, но он нам не особо нужен щас
*/

public class Solution {
    public static int A = 0;

    static {
        if (true)
            throw new RuntimeException("END ME PLS");
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
