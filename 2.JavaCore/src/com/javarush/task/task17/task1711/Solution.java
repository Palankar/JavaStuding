package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int counterC = 0;

                    while (counterC != args.length - 1) {
                        if (args[counterC + 2].equals("м"))
                            allPeople.add(Person.createMale(args[counterC + 1], new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[counterC + 3])));
                        else
                            allPeople.add(Person.createFemale(args[counterC + 1], new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[counterC + 3])));

                        System.out.println(allPeople.size() - 1);
                        counterC += 3;
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    int counterU = 0;

                    while (counterU != args.length - 1) {
                        allPeople.get(Integer.parseInt(args[counterU+1])).setName(args[counterU+2]);
                        if (args[counterU+3].equals("м"))
                            allPeople.get(Integer.parseInt(args[counterU+1])).setSex(Sex.MALE);
                        else
                            allPeople.get(Integer.parseInt(args[counterU+1])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.parseInt(args[counterU+1])).setBirthDate(new SimpleDateFormat("d/M/y", Locale.ENGLISH).parse(args[counterU+4]));
                        counterU += 4;
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    int counterD = 0;

                    while (counterD != args.length - 1) {
                        allPeople.get(Integer.parseInt(args[counterD+1])).setName(null);
                        allPeople.get(Integer.parseInt(args[counterD+1])).setSex(null);
                        allPeople.get(Integer.parseInt(args[counterD+1])).setBirthDate(null);
                        counterD++;
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    int counterI = 0;

                        while (counterI != args.length - 1) {
                            System.out.print(allPeople.get(Integer.parseInt(args[counterI+1])).getName() + " ");
                            if (allPeople.get(Integer.parseInt(args[counterI+1])).getSex().equals(Sex.MALE))
                                System.out.print("м ");
                            else
                                System.out.print("ж ");
                            System.out.println(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[counterI+1])).getBirthDate()));
                            counterI++;
                        }
                        break;
                }
        }
    }
}
