package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String fileName;
        ReadThread readThread;

        while (!(fileName = reader.readLine()).equals("exit")) {
            readThread = new ReadThread(fileName);
            readThread.start();
        }

        for (String s : resultMap.keySet()) {
            System.out.println(s + " " + resultMap.get(s));
        }
    }

    public static class ReadThread extends Thread {
        String filename;
        Map<Integer, Integer> allBytes = new HashMap<>();

        public ReadThread(String fileName) {
            this.filename = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream inStream = new FileInputStream(filename);

                int thisByte;
                while (inStream.available() > 0) {
                    if (!allBytes.containsKey((thisByte = inStream.read())))
                        allBytes.put(thisByte, 1);
                    else
                        allBytes.replace(thisByte, allBytes.get(thisByte) + 1);
                }
                inStream.close();

                //поиск наибольшего повторения байта
                int maxCount = Integer.MIN_VALUE;
                int maxByte = 0;
                for (Integer integer : allBytes.keySet()) {
                    if (allBytes.get(integer) > maxCount) {
                        maxCount = allBytes.get(integer);
                        maxByte = integer;
                    }
                }

                resultMap.put(filename, maxByte);

            } catch (IOException e) {

            }
        }
    }
}
