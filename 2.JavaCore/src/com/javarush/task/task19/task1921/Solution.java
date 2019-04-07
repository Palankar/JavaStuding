package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
-->Метод trim() от класса String озволяет подчистить пробелы в начале и в конце строки
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        String[] params;
        StringBuilder name = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
        StringBuilder date = new StringBuilder();
        while (fileReader.ready()) {
            params = fileReader.readLine().split(" ");

            for (int i = 0; i < params.length; i++) {
                if (i < params.length-3) {
                    name.append(params[i] + " ");
                } else {
                    date.append(params[i] + " ");
                }
            }

            try {
                PEOPLE.add(new Person(name.toString().trim(), dateFormat.parse(date.toString().trim())));
            } catch (ParseException e) {}

            name.setLength(0);
            date.setLength(0);
        }
        fileReader.close();

        for (Person person : PEOPLE) {
            System.out.println(person.getName() + " " + person.getBirthDate());
        }
    }
}
