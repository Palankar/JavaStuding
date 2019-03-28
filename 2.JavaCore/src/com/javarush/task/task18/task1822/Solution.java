package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap lines = new HashMap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inStream = new FileInputStream(reader.readLine());
        BufferedReader bufInStream = new BufferedReader(new InputStreamReader(inStream));
        reader.close();

        String line;
        while ((line = bufInStream.readLine()) != null) {
            lines.put(line.substring(0, line.indexOf(' ')), line);
        }

        inStream.close();
        bufInStream.close();

        System.out.println(lines.get(args[0]));
    }
}
