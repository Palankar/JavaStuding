package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
-->Отличный комментарий в комментах, который проясняет всю суть задачи:

Итак, что можно для себя вынести из задачи:

    1. Для сериализации объектов внутренних нестатических классов требуется, чтобы внешний класс также
    поддерживал сериализацию, т.к. такие объекты не могут быть созданы без участия внешнего класса,
    соответственно поддержка сериализации нужна и так и там. Был бы класс B статическим, этого бы не
    потребовалось.

    2. Класс A не поддерживает сериализацию, поэтому для инициализации его переменных будет вызываться
    конструктор по умолчанию. Поэтому конструктор нужно прописать ручками. Если бы класс A поддерживал
    сериализацию, городить пустой конструкто не пришлось бы, java бы знала, что у него есть конструктор
    с параметром и вызвала бы его.

    3. ОК, программа работает, но что-то вывод значений nameA до и после не совпадает...
    А все дело в том, что переменная nameA унаследовалась от класса A, который сериализацию не поддерживает.

    В п.2 при десериализации с помощью конструктора по умолчанию nameA инициализировалась, но ее значение
    не может быть восстановлено автоматически. Соответственно это надо делать вручную, дополняя сериализацию
    по умолчанию.

*/
public class Solution implements Serializable {     //Нужна поддержка сериализации, чтобы успешно серизовались НЕ СТАТИЧЕСКИЕ внутренние классы
    public static class A {

        protected String nameA = "A";

        public A() {}       //Нужно, поскольку сериализацию не поддерживает, а поля иначе инициализуются

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {      //Нужна поддержка сериализации по условию

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(nameA);         //Т.к. у переменной больше нет инициализации, но сама она есть - руками
            out.defaultWriteObject();       //Не забываем про дефолтные методы для сериализации остального
        }

        private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
            nameA = (String) in.readObject();   //Аналогично, но читаем
            in.defaultReadObject();             //Не забываем про дефолтные методы для сериализации остального
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B)ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
