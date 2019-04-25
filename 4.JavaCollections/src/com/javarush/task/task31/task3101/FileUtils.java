package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.ArrayList;

public class FileUtils {
    public ArrayList<File> allFiles = new ArrayList<>();
    public ArrayList<File> smallFiles = new ArrayList<>();

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }

    public void throwFiles(File path) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                throwFiles(file);
            } else {
                if (file.length() <= 50) {
                    allFiles.add(file);
                    smallFiles.add(file);
                } else {
                    allFiles.add(file);
                }
            }
        }
    }
}
