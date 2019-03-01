package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private int age;
        private boolean sex;
        private int weight;
        private int height;

        public Human() {
            System.out.println("Это человек");
        }
        public Human(String name) {
            this.name = name;
            System.out.println("Человека зовут " + this.name);
        }
        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
            System.out.println(name + " носит фамилию " + surname);
        }
        public Human(int age) {
            this.age = age;
        }
        public Human(boolean sex) {

        }
        public Human(boolean sex, int weight) {

        }
        public Human(int height, int weight) {

        }
        public Human(int weight, int height, int age) {

        }
        public Human(String name, boolean sex) {

        }
        public Human(String name, String surname, boolean sex) {

        }
    }
}
