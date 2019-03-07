package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.5, "Первый");
        labels.put(1.488, "Ницше");
        labels.put(7.40, "Израиль");
        labels.put(5.52, "Убойник");
        labels.put(4.14, "Страница");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
