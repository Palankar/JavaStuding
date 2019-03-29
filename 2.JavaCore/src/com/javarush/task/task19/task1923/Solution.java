package com.javarush.task.task19.task1923;

/* 
Слова с цифрами

-->Итак, пора немного разобраться с тем, что же значат символы регулярок:
    . - любой символ, кроме перевода строки;
    * - ноль или более вхождений;
    +  так называемый "квантор", обозначающий "один или больше раз";
Следовательно:
    \d+ - одна или более цифр;
    .* - неопределенное кол-во любых символов, кроме пробела;
    .*\d+.* - слово, состоящее из каких-то символов, где одна и более цифр, после которой неопределенное кол-во символов;
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        String[] thisLine;
        while (fileReader.ready()) {
            thisLine = fileReader.readLine().split(" ");
            for (String str : thisLine) {
                if (str.matches(".*\\d+.*"))
                    fileWriter.write(str + " ");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
