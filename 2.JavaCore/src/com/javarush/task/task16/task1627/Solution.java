package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

/*
-->Очень крутая по своей идее задачка. Все комменты расставил, так что оно должно быть вполне понятно по
тому, как она действует
 */

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        //показывает, найден победитель или нет
        public static volatile boolean isWinnerFound = false;

        //хранит последовательность действий, которое каждый игрок выполняет
        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            //игроки играют независимо друг от друга
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            try {
                for (String step : OnlineGame.steps) {
                    Thread.sleep(1000/rating);
                    System.out.println(toString(step));

                    //проверка на isWinnerFound не указана, но проводить ее нужно
                    if (step.equals("Убийство врагов") && OnlineGame.isWinnerFound != true) {
                        System.out.println(getName() + ":победитель!");
                        OnlineGame.isWinnerFound = true;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл");
            }
        }

        public String toString(String step) {
            return getName() + ":" + step;
        }
    }
}
