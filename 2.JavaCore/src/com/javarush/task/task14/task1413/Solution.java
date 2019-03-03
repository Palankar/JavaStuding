package com.javarush.task.task14.task1413;

/* 
Computer
--> Очень крутая задача, что дает понимание:
- Быстрого создания getter, setter и constructor в IDEA
- Использования конструктора класса с вложенными объектами
- Использования метода getSimpleName ля получения имени класса

UPD: получение имени лучше реализовать прямо в интерфейсе дефолтно, поскольку
его испольхуют все наследники
*/

public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer(new Keyboard(), new Mouse(), new Monitor());
        if (isWork(computer.getKeyboard()) &&
                isWork(computer.getMonitor()) &&
                isWork(computer.getMouse())) {
            System.out.println("Work!");
        }
    }

    public static boolean isWork(CompItem item) {
        System.out.println(item.getName());
        return item.getName() != null && item.getName().length() > 4;
    }

}
