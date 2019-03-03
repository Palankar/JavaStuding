package com.javarush.task.task14.task1413;

/*
Очень крутая штука, о которой не стоит забывать - дефолтные методы.
Они стандартно могут использоваться во всех классах, реализующих
этот интерфейс
*/

public interface CompItem {
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
