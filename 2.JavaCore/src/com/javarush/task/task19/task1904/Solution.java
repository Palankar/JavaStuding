package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
-->Парсинг - это процесс сбора необходимой информации. В данном случае, парсинг строки представляет
собой разделение этой самой строки на нужные нам смысловые элементы и занесение их по порядку
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Date date = null;
            String person = fileScanner.nextLine();
            String[] arr = person.split(" ", 4);
            try {
                date = new SimpleDateFormat("dd MM yyyy").parse(arr[3]);
            } catch (ParseException e) {}
                return new Person(arr[1], arr[2], arr[0], date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
