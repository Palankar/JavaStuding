package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int one = Integer.parseInt(reader.readLine());
            int two = Integer.parseInt(reader.readLine());
            if (one <= 0 || two <= 0) {
                throw new Exception();
            } else {
                while (one != two) {
                    if (one > two) {
                        one = one - two;
                    } else {
                        two = two - one;
                    }
                }
                System.out.println(one);
            }
    }
}
