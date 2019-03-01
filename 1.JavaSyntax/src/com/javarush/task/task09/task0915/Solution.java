package com.javarush.task.task09.task0915;

import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.FileSystemException;

/* 
Перехват выборочных исключений
--> Логгирование... Прочитаешь потом вместе с бинами. Да.
по сути, задачка простая, но мудреная по условию, в котором
еще есть и ошибки. Сразу лучше смотреть на требования и
полностью забить на все описание.
*/

public class Solution {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) throws Exception {
        try {
            handleExceptions();
        }
        catch (Exception e) {
            BEAN.log(e);
        }
    }

    public static void handleExceptions() throws Exception, FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        }
        catch (FileSystemException e) {
            BEAN.log(e);
            throw e;
        }
        catch (CharConversionException e) {
            BEAN.log(e);
        }
        catch (IOException e) {
            BEAN.log(e);
        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
}
