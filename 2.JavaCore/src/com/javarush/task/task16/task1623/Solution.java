package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
-->Тот самый случай, когда название задачи отлично отражает ее суть.
Переопределение toString() позволяет получать имя нити, что задается при
вызове конструктора в super(). После конструктор инициирует запуск потока,
который в свою очередь выводит на экран и создает поток, запуская тот же
конструктор при создании объекта. Рекурсия.
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
            if (createdThreadCount < Solution.count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
