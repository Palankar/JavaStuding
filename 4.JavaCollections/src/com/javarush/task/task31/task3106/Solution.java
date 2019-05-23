package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        /*
        ArrayList entryNames = new ArrayList();
        for (int i = 1; i < args.length; i++) {
            entryNames.add(args[i].substring(args[i].lastIndexOf('.') + 1));
        }

        Path archivePath = Paths.get(args[1].substring(0, args[1].lastIndexOf('.')));
        FileOutputStream fos = new FileOutputStream(args[0], true);

        FileInputStream fis = new FileInputStream(archivePath.toString());
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {
            if (entryNames.contains(entry.getName().substring(0, entry.getName().lastIndexOf('.')))) {
                byte[] buffer = new byte[(int) entry.getSize()];
                zis.read(buffer);
                fos.write(buffer);
            }
            zis.closeEntry();
        }

        zis.close();
        fis.close();
        fos.close();
        */


        String resultFileName = args[0];
        ArrayList<String> fileNameParts = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            fileNameParts.add(args[i]);
        }
        Collections.sort(fileNameParts);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < fileNameParts.size(); i++) {
            fisList.add(new FileInputStream(fileNameParts.get(i)));
        }

        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);

        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }

        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}
