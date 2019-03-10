package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Парсер реквестов
--> И-и-и снова я создал монстра. Жуткого и страшного монстряку, которого стоит позже исправить.
Но как бы то ни было - это вполне рабочий, написанный моими руками, парсер.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String url = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String allParams = url.substring(url.indexOf("?") + 1);
        ArrayList params = new ArrayList();

        while (allParams.contains("&")) {
            params.add(allParams.substring(allParams.lastIndexOf("&")+1));
            allParams = allParams.substring(0, allParams.lastIndexOf("&"));
        }
        params.add(allParams.substring(allParams.lastIndexOf("&")+1));

        Collections.reverse(params);
        for (Object param : params) {
            if (params.size() != params.indexOf(param)) {
                if (param.toString().contains("="))
                    System.out.print(param.toString().substring(0, param.toString().indexOf("=")) + " ");
                else
                    System.out.print(param.toString() + " ");
            } else {
                if (param.toString().contains("="))
                    System.out.print(param.toString().substring(0, param.toString().indexOf("=")));
                else
                    System.out.print(param.toString());
            }
        }
        System.out.println();

        for (Object param : params) {
            if (param.toString().contains("obj"))
                try {
                    alert(Double.valueOf(param.toString().substring(param.toString().indexOf("=") + 1)));
                } catch (Exception e) {
                    alert(param.toString().substring(param.toString().indexOf("=") + 1));

                }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
