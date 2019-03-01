package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
--> , тоже не долго ломал голову. Главное было вспомнить
примененный ранее в задачах методы toCharArray(). Стоп,
а когда я его успел выучить?..
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        String vowelString = "";
        String consonantString = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (char ch : reader.readLine().toCharArray()) {
            if (isVowel(ch) == true && ch != ' ')
                vowelString += ch + " ";
            else if (isVowel(ch) == false && ch != ' ')
                consonantString += ch + " ";
        }
        System.out.println(vowelString);
        System.out.println(consonantString);


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}