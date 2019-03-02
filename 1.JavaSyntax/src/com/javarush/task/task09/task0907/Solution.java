package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами
--> Довольно глупое задание по смыслу, поскольку пытался отловить
именно сам тип, а нужно было все сообщение выдать. Ничего лсожного.
Выбираем нужный тип, затем выводим по try-catch.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            int a = 42 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
