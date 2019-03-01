package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
-->Интересная задачка, но вплоне простая. Нужно лишь вспомнить:
- Даты;
- Форматирование дат;
- Методы String;
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Date dateOne = new SimpleDateFormat("yyyy-MM-dd").parse(reader.readLine());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        System.out.println(simpleDateFormat.format(dateOne).toUpperCase());
    }
}
