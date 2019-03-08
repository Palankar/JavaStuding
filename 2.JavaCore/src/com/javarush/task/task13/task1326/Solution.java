package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
--> Итак, я создал монстра. Мерзкого и грящного монстра. Я отлично понимаю, что
это какой-то говнокод, однако он рабочий, а лучше я пока не придумал. Думаю,
стоит вернуться к этой задаче позже, чтобы отрихтовать написанное до нормального
состояния.

P.S. Писал задачу уже после прохождениия лекций про потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName.readLine()));
        fileName = new BufferedReader(new InputStreamReader(bufferedInputStream));

        ArrayList list = new ArrayList();
        String data;
        while ((data = fileName.readLine()) != null) {
            if ((Integer.parseInt(data) % 2) == 0) {
                list.add(Integer.parseInt(data));
            } else
                continue;
        }
        fileName.close();
        bufferedInputStream.close();

        Collections.sort(list);
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }
}
