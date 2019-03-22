package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
-->Делигируем выполнение методов объекту исходного класса в любом случае, но при необходимости
можно нарастить на него свои условия или модификации
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream component;

    public QuestionFileOutputStream(AmigoOutputStream component) {
        this.component = component;
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer;

        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        if ((answer = reader.readLine()).equals("Д"))
            component.close();
    }
}

