package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;

        while (true) {
            if ((key = reader.readLine()).equals("cartoon") || key.equals("thriller") || key.equals("soapOpera")) {
                System.out.println(MovieFactory.getMovie(key).getClass().getSimpleName());
            } else {
                MovieFactory.getMovie(key);
                break;
            }
        }

        reader.close();

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key))
                movie = new SoapOpera();
            else if ("cartoon".equals(key))
                movie = new Cartoon();
            else if ("thriller".equals(key))
                movie = new Thriller();

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
