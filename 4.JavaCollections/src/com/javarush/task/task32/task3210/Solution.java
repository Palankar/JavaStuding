package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(Integer.parseInt(args[1]));

        byte[] buffer = new byte[args[2].length()];
        raf.read(buffer, 0, buffer.length);

        if (new String(buffer, "UTF-8").equals(args[2])) {
            raf.seek(raf.length());
            raf.write("true".getBytes());
        } else {
            raf.seek(raf.length());
            raf.write("false".getBytes());
        }

        raf.close();
    }
}
