package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {
    private static int folders = 0;
    private static int files = 0;
    private static int size = 0;

    public static void main(String[] args) throws Exception {

        Path folderPath = Paths.get(new Scanner(System.in).nextLine());
        if (!Files.isDirectory(folderPath)) {
            System.out.println(folderPath.toAbsolutePath() + " - не папка");
            return;
        }

        Files.walkFileTree(folderPath, new MyFileVisitor());

        System.out.println("Всего папок - " + (folders - 1));
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {
            size += attrs.size();
            files++;

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            folders++;

            return FileVisitResult.CONTINUE;
        }
    }
}
