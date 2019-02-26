package com.javarush.task.task09.task0929;

import java.io.*;

/* 
Обогатим код функциональностью!
--> !!!НЕ РЕШЕНА!!!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            InputStream fileInputStream = getInputStream(reader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует.");
        }
        InputStream fileInputStream = getInputStream(reader.readLine());

        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

