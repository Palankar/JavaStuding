package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
-->Нити будут запускаться последовательно (что, конечно, в данном случае
лишено смысла), поскольку main поток перед созданием нового объекта SleepingThread,
в конструкторе которого и запускается дочерний поток, будет ждать завершения сего потока,
перед тем как создать новый объект, продолжив итерации цикла for()
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join();
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countdownIndex == 0) return;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                }
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
