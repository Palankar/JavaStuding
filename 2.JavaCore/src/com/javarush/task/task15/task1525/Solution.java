package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
--> Что ты ждешь? Все в описании и так есть на функциях. Сиди себе и смотри
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    // Добавляет значения в список ДО запуска основного метода
    static {
        try {
            // Поток чтения из файла
            InputStream inputStream = new FileInputStream(Statics.FILE_NAME);
            // Буферезированный поток, чтоб читалось быстрее (в теории)
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 200);
            // Читает текст из потока ввода символов, буферизуя прочитанные символы, чтобы обеспечить эффективное считывание символов, массивов и строк
            BufferedReader reader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            String data;
            while ((data = reader.readLine()) != null) {
                lines.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка пути");
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
