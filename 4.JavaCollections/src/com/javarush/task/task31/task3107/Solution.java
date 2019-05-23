package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            boolean hidden = false;
            boolean executable = false;
            boolean directory = false;
            boolean writable = false;

            if (Files.isHidden(Paths.get(pathToFile)))
                hidden = true;
            if (Files.isExecutable(Paths.get(pathToFile)))
                executable = true;
            if (Files.isDirectory(Paths.get(pathToFile)))
                directory = true;
            if (Files.isWritable(Paths.get(pathToFile)))
                writable = true;

                fileData = new ConcreteFileData(hidden, executable, directory, writable);

        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
