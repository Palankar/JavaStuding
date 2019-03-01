package com.javarush.task.task13.task1320;

/* 
Neo
--> Так, блэт! Тут все не так однозначно. Снова...
Суть в том, что при вызове return идет возврат текущего
объекта при помощи return this. Охренеть - так тоже можно.
Плюс имеет ОГРОМНОЕ значение то, какого типа возвратная переменная
в методе.
В Matrix мы присваиваем переменной типа DBObject объект типа
User лишь потому, что идет имплементация интерфейса этим классом.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

        @Override
        public User initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }
    }
}
