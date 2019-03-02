package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
--> Офигеть, я его написал. Это круто. Ровно то, что я бы хотел научиться делать
год назад, когда только-только начинал лезть в эту тему. У-у-ух, ну теперь-то работа
с файлами пойдет в гору, хе-хе...)
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));

        InputStream inStream = new FileInputStream(fileName.readLine());
        while (inStream.available() > 0) {
            System.out.print((char)inStream.read());
        }

        fileName.close();
        inStream.close();
    }
}