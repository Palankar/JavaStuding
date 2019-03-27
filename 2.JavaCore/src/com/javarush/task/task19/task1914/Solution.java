package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String[] strings = outputStream.toString().split(" ");
        String expression = outputStream.toString().replaceAll("[\\r\\n]", "");
        if (strings[1].equals("+"))
            System.out.print(expression + (Integer.parseInt(strings[0]) + Integer.parseInt(strings[2])));
        else if (strings[1].equals("-"))
            System.out.print(expression + (Integer.parseInt(strings[0]) - Integer.parseInt(strings[2])));
        else if (strings[1].equals("*"))
            System.out.print(expression + (Integer.parseInt(strings[0]) * Integer.parseInt(strings[2])));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

