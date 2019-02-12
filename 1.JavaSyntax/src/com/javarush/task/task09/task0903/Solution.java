package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
--> А тут у нас некоторая неоднозначность. В чем?
Да потому что имеется в виду строка кода, под которой
и находится сам метод, а не строка в терминале.
Читай внимательней.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        method2();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method2() {
        method3();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method3() {
        method4();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method4() {
        method5();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method5() {

        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }
}
