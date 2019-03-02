package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* 
Метод в try..catch
--> Тут хитро, поскольку с выбрасыванием он все равно требует себе
IOException, но нам он не сильно нужем, а потому пустой.
А так, интересная и прикладная задачка.
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() throws NumberFormatException{
        LinkedList<Integer> list = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < i+1; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (NumberFormatException e) {
            for (int num : list) {
                System.out.println(num);
            }
        }
        catch (IOException e) {}
    }
}
