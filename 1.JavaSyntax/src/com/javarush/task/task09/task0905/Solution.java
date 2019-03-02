package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
--> Простая задачка на получение и вывеление размера трассировочноего стека на
экран. При этом я не совсем верно решил, отправив sout в метод. Но прокатило.
Хотя лично я ИМХО, шо в main надо лишь вызовы первичных методов пихать,
а не переменные. Так что норм.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        int elements = Thread.currentThread().getStackTrace().length;
        System.out.println(elements);
        return elements;
    }
}

