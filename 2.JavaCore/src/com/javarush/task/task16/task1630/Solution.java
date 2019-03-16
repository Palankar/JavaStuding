package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    //статики для имен файла

    public static String firstFileName;
    public static String secondFileName;

    //ввод имен, инициализация
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {}
    }

    //main() лишь печатает файлы по итогу, все остальное само внутри
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    /*
    создает объект и вызывает методы
        - задания имени
        - старта потока
        - ожидания завершения потока до вывода в печать
        - вывод результата в печать
     */
    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    //просто интерфейсы ридера файлов
    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //класс-поток, где вся петрушка и творится
    public static class ReadFileThread extends Thread implements ReadFileInterface, Runnable {
        private String fileName;
        private BufferedReader reader;
        private String fileContent = "";

        //задание имени
        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        //процесс чтения в потоке
        @Override
        public void run() {
            String nowContent;

            try {
                InputStream inputStream = new FileInputStream(fileName);
                reader = new BufferedReader(new InputStreamReader(inputStream));

                while ((nowContent = reader.readLine()) != null) {
                    fileContent += nowContent + " ";
                }

                reader.close();
            } catch (IOException e) {
                System.out.println("Неверное имя файла");
            }
        }

        //получение результата чтения
        @Override
        public String getFileContent() {
            return fileContent;
        }
    }
}
