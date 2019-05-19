package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {

        URL url = new URL(urlString);
        InputStream inStream = url.openStream();
        Path tmp = Files.createTempFile("temp-", ".tmp");
        Files.copy(inStream, tmp, StandardCopyOption.REPLACE_EXISTING);
        inStream.close();
        Files.move(tmp, Paths.get(downloadDirectory + "/" + Paths.get(url.getFile()).getFileName()), StandardCopyOption.REPLACE_EXISTING);

        return Paths.get(downloadDirectory + "/" + Paths.get(url.getFile()).getFileName());

        /*
        Path result = Paths.get(downloadDirectory.toString(), urlString.split(".+/",2)[1]);
        URL url = new URL(urlString);
        InputStream inSream = url.openStream();
        //тут из пути вырезаем имя временного файла, оставляя только путь до него.
        //Path tmp=Paths.get(Files.createTempFile("name-[", "]").toString().split(".+\\\\",2)[1]);
        //А здесь в пути указано также и имя этого созданного файла, поэтому и возникает ошибка при попытке работать с этим путём.
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inSream, tempFile);
        Files.move(tempFile, downloadDirectory);

        return Paths.get(new String(Files.readAllBytes(downloadDirectory)));
        */
    }
}
