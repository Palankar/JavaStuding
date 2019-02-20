package com.javarush.task.task12.task1201;

/* 
Киты и коровы
--> На самомо деле, очень важная, хоть и простая задачка. Тут явно
видно, как работают вызываемые методы при определенном объявлении
объекта. Важно именно то, что написано после "=", именно его методы и
будут использоваться. Потому что именно это - тип объекта. А первое - это
просто тип класса.
*/

public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        @Override
        public String getName() {
            return "Я не корова, Я - кит.";
        }
    }
}
