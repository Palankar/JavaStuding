package com.javarush.task.task16.task1607;

import java.util.ArrayList;
import java.util.List;

/* 
Horse Racing
--> Тут все не просто. Сама по себе задачка требует либо очень внимательно и
послежовательно вчитаться, либо пройтись по ней дебагом. Что тоже не сильно
упростит, поскольку  еще не понял, как грамотно переключаться на параллельные
потоки.

- Создается массив объектов лошадей:
(Лошади наследуются от Thread и имеют свою реализацию run(), очень струнную)
- Перебором запускаем у всех лошадей поток выполнения
- Параллельно пускаем перебор объектов и проверяем при помощи внутренней переменной Horse,
был ли запуск. Если нет, то ждем его и идем дальше, чтобы не пропустить лошадок
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).isFinished()) {
                finishedCount++;
            } else {
                System.out.println("Waiting for " + horses.get(i).getName());
                horses.get(i).join();
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i < horseCount + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   // Delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}
