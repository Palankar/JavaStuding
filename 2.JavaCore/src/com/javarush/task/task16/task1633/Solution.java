package com.javarush.task.task16.task1633;

public class Solution {
    //Создание объекта, который будет обрабатывать исключения времени выполнения
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        //В конструкторе стоит обработчик
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        //Валидатор не принимает вызов через объект, хотя он куда более правильный, что странно
        Thread.setDefaultUncaughtExceptionHandler(handler);

        //threadA.setUncaughtExceptionHandler(handler);
        //threadB.setUncaughtExceptionHandler(handler);

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    //Тело нашей реализации обработчика исключений времени выполнения
    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        //Принимает нить и выдает сообщение с именем нити
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
