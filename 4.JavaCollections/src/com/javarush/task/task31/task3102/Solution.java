package com.javarush.task.task31.task3102;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
-> Вот тут на самом деле пришлось немного пораскинуть мозгами. Поскольку Queue до этого не изучалось,
а единственное, что я помню по подобной теме - это Stack. В итоге сработало просто отлично.
Ну и не буду лукавить, воспользовался советом при поиске пути решения со StackOverflow...)
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> filesList = new ArrayList<>();
        Stack<String> taskList = new Stack<>();
        taskList.add(root);
        
        while (!taskList.empty()) {
            File temp = new File(taskList.pop());

            for (File file  :   temp.listFiles()) {
                if (file.isDirectory())
                    taskList.add(file.getAbsolutePath());
                else if (file.isFile())
                    filesList.add(file.getAbsolutePath());
            }
        }

        return filesList;
    }

    public static void main(String[] args) throws IOException {
        for (String path : getFileTree("C:\\Users\\palan\\Desktop\\Интересное")) {
            System.out.println(path);
        }
    }
}
