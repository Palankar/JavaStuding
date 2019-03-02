package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
--> Так, тут пришлось поломать голову, поскольку жо этого внятного объяснения работы
подобного класса просто не было физически. Опишу и разберу его отдельно.
И да, СТОИТ ЗНАТЬ, ЧТО:
Если потоки ввода/вывода под конец не закрыты, то данные в файле не сохраняются.
Так что закрывать их стоит не только для избежания утечки памяти, но и для
полноценной работы программы.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //Чтение с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Указание пути файла и самого файла
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        //Цикд с записью введенного в консоль
        while (true) {
            String s = reader.readLine();       //Чтобы можно было проверить условие
            if(s.equals("exit")) {
                writer.write(s);
                break;
            } else {
                writer.write(s);
                writer.newLine();
            }

        }
        reader.close();
        writer.close();
    }
}
