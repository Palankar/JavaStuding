package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int min(int one, int two) {
        if (one > two)
            return two;
        else
            return one;
    }
    public static long min(long one, long two) {
        if (one > two)
            return two;
        else
            return one;
    }
    public static double min(double one, double two) {
        if (one > two)
            return two;
        else
            return one;
    }
}
