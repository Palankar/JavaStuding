package com.javarush.task.task19.task1911;

/* 
Ридер обертка
-->В чем петрушка этой задачи:
    Мы заранее запомнили переменную потока вывода в консоль out,
    потом задали свой динамический массив - поток,
    впихнули его заместо старого out свой массив-поток,
    использовали метод вывода в консоль, но т.к. out - теперь наш массив,
    то и записались данные в него.
    Вернули out на место.
    Воспользовались System.out, что теперь снова работает с потоком
    вывода в консоль и передали наш массив, в котором уже запомнено
    значение, что было ранее, извратились над ним как хотим и выводим.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Подменяем поток вывода в консоль
        System.setOut(stream);
        testString.printSomething();
        //Восстанавливаем поток вывода в консоль
        System.setOut(consoleStream);

        System.out.println(outputStream.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
