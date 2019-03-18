package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        //first
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //second
        try {
            String[] strings = new String[3];
            System.out.println(strings[5]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        //third
        try {
            Object[] strings = new String[3];
            strings[0] = 4.4;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //fourth
        try {
            Object num = new Integer(5);
            String str = (String)num;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //fifth
        try {
            Stack stack = new Stack();
            stack.peek();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //sixth
        try {
            String str = "некий текст";
            char ch = str.charAt(50);

        } catch (Exception e) {
            exceptions.add(e);
        }

        //seventh
        try {
            Integer[] integers = new Integer[-5];

        } catch (Exception e) {
            exceptions.add(e);
        }

        //eighth
        try {
            String a = null;
            String b = a.toString();

        } catch (Exception e) {
            exceptions.add(e);
        }

        //ninth
        try {
            String str = "ф";
            Integer.parseInt(str);

        } catch (Exception e) {
            exceptions.add(e);
        }


        //tenth
        try {
            BufferedReader reader = new BufferedReader(new FileReader(""));

        } catch (Exception e) {
            exceptions.add(e);
        }

    }
}
