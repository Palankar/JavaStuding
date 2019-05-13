package com.javarush.task.task31.task3111;

import org.omg.CORBA.Object;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        boolean containsName = true;
        if(partOfName!=null && !file.getFileName().toString().contains(partOfName))
            containsName = false;
        boolean containsContent = true;
        if(partOfContent!=null && !new String(content).contains(partOfContent))
            containsContent = false;

        boolean lessThanMax = true;
        if (Objects.nonNull(maxSize) && !(content.length <= maxSize) && maxSize != 0)
            lessThanMax = false;
        boolean moreThanMin = true;
        if (Objects.nonNull(minSize) && !(content.length >= minSize) && minSize != 0)
            moreThanMin = false;

        if (containsName && containsContent && lessThanMax && moreThanMin) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
