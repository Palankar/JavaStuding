package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        File path  = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        FileUtils utils = new FileUtils();

        utils.throwFiles(path);
        Collections.sort(utils.smallFiles, Comparator.comparing(File::getName));

        File resultFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(resultFile)) utils.renameFile(resultFileAbsolutePath, resultFile);

        FileWriter fileWriter = new FileWriter(resultFile, true);
        for (File smallFile : utils.smallFiles) {
            FileReader fileReader = new FileReader(smallFile);
            while (fileReader.ready()) {
                fileWriter.write(fileReader.read());
            }
            fileWriter.write("\n");
            fileReader.close();
        }
        fileWriter.close();
    }
}
