package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);

        //Проверяет файлы на существование (валидатор считает лишним)

        if (!Files.exists(source)) {
            throw new FileNotFoundException();
        }
        if (!Files.exists(zipFile)) {
            throw new FileNotFoundException();
        }

        boolean contains = false; //укажет, если в архиве содержится входящий файл

        Map<ZipEntry, byte[]> zipEntries = new LinkedHashMap<>(); //коллекция в которой будем хранить файлы архива
        List<ZipEntry> directories = new ArrayList<>(); //коллекция для директорий (нужна для случая, когда в архиве содержатся пустые папки)

        InputStream in = new FileInputStream(args[1]); //Открываем входящий поток
        ZipInputStream zis = new ZipInputStream(in);   //Открываем входящий zip-поток

        ZipEntry ze = zis.getNextEntry();

        findFiles(ze, zipEntries, directories, zis); //собираем в коллекции файлы архива

        zis.closeEntry();

        zis.close(); //Закрываем входящий поток
        in.close();  //Закрываем входящий zip-поток

        OutputStream out = new FileOutputStream(args[1]); //Открываем исходящий поток
        ZipOutputStream zos = new ZipOutputStream(out);   //Открываем исходящий zip-поток

        //Записываем в наш архив директории
        for (ZipEntry z : directories){
            zos.putNextEntry(z);
            zos.closeEntry();
        }

        //Записываем в наш архив файлы
        for ( Map.Entry<ZipEntry, byte[]> z : zipEntries.entrySet() ) {
            z.getKey().setCompressedSize(-1);
            zos.putNextEntry(z.getKey());
            Path file = Paths.get(z.getKey().getName());
            if (file.getFileName().equals(source.getFileName())) {  //если в архиве содержится входящий файл
                Files.copy(source, zos);  //переносим данные с файла в архивный
                contains = true; //устанавливаем значение - истина
            } else {
                zos.write(z.getValue());
            }
            zos.closeEntry();
        }
        //Если входящего файла в архиве не было, тогда записываем его в архив в директорию "new"
        if (!contains) {
            zos.putNextEntry(new ZipEntry(String.valueOf(Paths.get("new")
                    .resolve(Paths.get(args[0]).getFileName()))));
            Files.copy(source, zos);
            zos.closeEntry();
        }

        zos.close(); //Закрываем исходящий поток
        out.close(); //Закрываем исходящий zip-поток
    }

    //Метод для перебора файлов архива
    public static void findFiles(ZipEntry ze, Map<ZipEntry, byte[]> zipEntries, List<ZipEntry> directories,
                                 ZipInputStream zis) throws IOException {
        while (ze != null){
            if (!ze.isDirectory()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Временное хранилище содержимого ZipEntry
                copyData(zis, baos); //Читаем ZipEntry во временное хранилище
                byte[] b = baos.toByteArray();

                zipEntries.put(ze, b);  //записываем файл
            } else {
                directories.add(ze);  //записываем директорию
            }
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
    }
    //Метод для чтения ZipEntry
    public static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
