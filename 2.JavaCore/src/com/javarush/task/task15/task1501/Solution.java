package com.javarush.task.task15.task1501;

/* 
ООП - Расставить интерфейсы
--> Обрати внимание на то, что тут реализован метод с одинаковым названием:
getAllowedAction. Его использование зависит от вида - есть ли передаваемый
параметр. Как с конструкторами класса. В зависимости от наличия и вызывается метод
того или иного интерфейса
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        boolean isMovable();
    }

    public interface Sellable {
        Object getAllowedAction(String name);
    }

    public interface Discountable {
        Object getAllowedAction();
    }

    public static class Clothes implements Movable, Sellable, Discountable {
        @Override
        public boolean isMovable() {
            return false;
        }

        @Override
        public Object getAllowedAction(String name) {
            return null;
        }

        @Override
        public Object getAllowedAction() {
            return null;
        }
    }
}
