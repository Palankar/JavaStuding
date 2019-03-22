package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> bytesMap = new HashMap<>();
        int thisByte;
        int maxCount = Integer.MIN_VALUE;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inStream = new FileInputStream(reader.readLine());

        while (inStream.available() > 0) {
            if (!bytesMap.containsKey((thisByte = inStream.read()))) {
                bytesMap.put(thisByte, 1);
            } else {
                bytesMap.replace(thisByte, bytesMap.get(thisByte) + 1);
                if (maxCount < bytesMap.get(thisByte))
                    maxCount = bytesMap.get(thisByte);
            }
        }

        for (Integer integer : bytesMap.keySet()) {
            if (bytesMap.get(integer) == maxCount)
                System.out.print(integer + " ");
        }

        reader.close();
        inStream.close();
    }
}