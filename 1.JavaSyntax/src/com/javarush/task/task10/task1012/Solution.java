package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
--> Жопа. Простая задача, на котрую убил под час потому, что плохо разбирался
в порядке сортирвки Map коллекций. В итоге, в заданном порядке отлично работает
LinkedHashMap. Также сортировать умеет TreeMap, но она уже не может в букву "ё",
ставя ее в конец списка.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        //Создание коллекции результата
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Character character : alphabet) {
            result.put(character, 0);
        }

        //Заполнение массива по условию
        for (int i = 0; i < list.size(); i++) {
            char[] word = list.get(i).toCharArray();
            for (int j = 0; j < word.length; j++) {
                for (int k = 0; k < alphabet.size(); k++) {
                    if (word[j] == abcArray[k]) {
                        result.replace(word[j], result.get(word[j]) + 1);
                    }
                }
            }
        }

        //Вывод
        for (Character character : result.keySet()) {
            System.out.println(character + " " + result.get(character));
        }
    }
}
