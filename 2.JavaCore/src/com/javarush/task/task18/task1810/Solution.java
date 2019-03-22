package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream;

        while (true) {
            inStream = new FileInputStream(reader.readLine());
            if (inStream.available() < 1000)
                break;
        }

        reader.close();
        inStream.close();
        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
