package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
--> По сути, довольно простая задачка на закрепление. Хотя нужно
учесть один момент - итератор для трассировки стека - штука недоступная.
В итоге приходится пользоваться циклами и условиями fori().
break; просто для экономии. Чтобы в пустую не считала.
*/


public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for (int i = 0; i < stackTraceElements.length-1; i++) {
            if (stackTraceElements[i].getMethodName() == "log") {
                System.out.println(stackTraceElements[i + 1].getClassName() + ": " + stackTraceElements[i +1].getMethodName() + ": " + s);
                break;
            }
        }
    }
}
