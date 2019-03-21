package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inFileOne = new FileInputStream(reader.readLine());
        FileOutputStream outFileTwo = new FileOutputStream(reader.readLine());
        FileOutputStream outFileThree = new FileOutputStream(reader.readLine());

        if (inFileOne.available() > 0) {
            byte[] buffer = new byte[inFileOne.available()];
            int bufferLength = inFileOne.read(buffer);

            outFileTwo.write(buffer, 0, bufferLength - bufferLength/2);    //запись во второй файл первую половину первого файла (большую часть)
            outFileThree.write(buffer, bufferLength - bufferLength/2, bufferLength/2);  //запись в трейтий файл оставшуюся часть первого файла
        }

        reader.close();
        inFileOne.close();
        outFileTwo.close();
        outFileThree.close();
    }
}
