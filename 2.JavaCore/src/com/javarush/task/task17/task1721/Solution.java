package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

    public static void main(String[] args) {
        String content;
        InputStream inStream;
        BufferedReader fileReader;
        Solution obj = new Solution();

        try {
            for (int i = 0; i < 2; i++) {
                inStream = new FileInputStream(reader.readLine());
                fileReader = new BufferedReader(new InputStreamReader(inStream));

                while ((content = fileReader.readLine()) != null)
                    if (i == 0)
                        allLines.add(content);
                    else
                        forRemoveLines.add(content);

                fileReader.close();
            }
            reader.close();

            obj.joinData();
        } catch (CorruptedDataException e) {

        } catch (IOException e) {
            System.out.println("Неправильный формат ввода");
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
