package com.javarush.task.task09.task0913;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/* 
Исключения. Просто исключения.
Хитровыбоенная задачка, которая решается ну очень простым образом. Особо не
думаем и в тупую вписываем нужные методы в catch. Наследие от Exception
всего и вся нам это активно позволяет.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            method1();
        }
        catch (NullPointerException e) {}
        catch (FileNotFoundException e) {}
    }

    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        if (i == 0)
            throw new NullPointerException();
        if (i == 1)
            throw new ArithmeticException();
        if (i == 2)
            throw new FileNotFoundException();
        if (i == 3)
            throw new URISyntaxException("", "");
    }
}
