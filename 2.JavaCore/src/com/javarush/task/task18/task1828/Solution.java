package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileAnalyser analyser = new FileAnalyser(fileName);
        FileManager manager = new FileManager(fileName);

            switch (args[0]) {
                case "-c":
                    if (args.length >= 4)
                    manager.addLine(new Line(args[1], args[2], args[3], analyser.maxId()+1));

                    break;
                case "-u":
                    if (args.length >= 4)
                    manager.changeLine(Integer.parseInt(args[1].replaceAll(" ", "")), args[2], args[3], args[4]);

                    break;
                case "-d":
                    manager.deleteLine(Integer.parseInt(args[1].replaceAll(" ", "")));
                    break;
            }

            analyser.close();
            manager.close();
    }

    public static class Line {
        private ArrayList<String> attributes = new ArrayList<>(4);

        public Line(String productName, String price, String quantity, int id) {
            parsing(productName, price, quantity);
            setId(id);
        }

        public void parsing(String productName, String price, String quantity) {
            attributes.add(productName.replaceAll("  ", ""));
            attributes.add(price.replaceAll(" ", ""));
            attributes.add(quantity.replaceAll(" ", ""));
        }

        public void setId(int id) {
            attributes.add(0, String.valueOf(id));
        }

        public String getId() {
            return attributes.get(0);
        }

        public String getProductName() {
            return attributes.get(1);
        }

        public String getPrice() {
            return attributes.get(2);
        }

        public String getQuantity() {
            return attributes.get(3);
        }

        public String getLine() {
            StringBuilder line = new StringBuilder();

            line.append(getId());
            for (int i = getId().length(); i < 8; i++) {
                line.append(" ");
            }
            line.append(getProductName());
            for (int i = getProductName().length(); i < 30; i++) {
                line.append(" ");
            }
            line.append(getPrice());
            for (int i = getPrice().length(); i < 8; i++) {
                line.append(" ");
            }
            line.append(getQuantity());
            for (int i = getQuantity().length(); i < 4; i++) {
                line.append(" ");
            }

            return line.toString();
        }
    }

    public static class FileAnalyser {
        private String fileName;
        private BufferedReader reader;

        public FileAnalyser(String fileName) throws IOException {
            this.fileName = fileName;
            this.reader = new BufferedReader(new FileReader(this.fileName));
        }

        public int numOfLines() throws IOException {
            int count = 0;
            while (reader.ready()) {
                reader.readLine();
                count++;
            }

            return count;
        }

        public int maxId() throws IOException {
            int thisId;
            int maxId = Integer.MIN_VALUE;

            while (reader.ready()) {
                thisId = Integer.parseInt(reader.readLine().substring(0, 8).replaceAll(" ", ""));
                if (thisId > maxId) maxId = thisId;
            }

            return  maxId;
        }

        public void close() throws IOException {
            this.reader.close();
        }
    }

    public static class FileManager {
        private String fileName;
        private BufferedReader reader;
        private BufferedWriter clearWriter;
        private BufferedWriter writer;

        public FileManager(String fileName) throws IOException {
            this.fileName = fileName;
            this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
        }

        public void addLine(Line line) throws IOException {
            writer.newLine();
            writer.write(line.getLine());
        }

        public void changeLine(int id, String productName, String price, String quantity) throws IOException {
            ArrayList<String> lines = new ArrayList<>();
            String thisLine = null;

            while (reader.ready()) {
                thisLine = reader.readLine();

                if (thisLine.substring(0, 8).replaceAll(" ", "").equals(String.valueOf(id))) {
                    thisLine = new Line(productName, price, quantity,
                            Integer.parseInt(thisLine.substring(0, 8).replaceAll(" ", ""))).getLine();
                }
                lines.add(thisLine);
            }

            this.clearWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (int i = 0; i < lines.size(); i++) {
                clearWriter.write(lines.get(i));
                if (i != lines.size()-1) {
                    clearWriter.newLine();
                }
            }
        }

        public void deleteLine(int id) throws IOException {
            ArrayList<String> lines = new ArrayList<>();
            String thisLine = null;

            while (reader.ready()) {
                thisLine = reader.readLine();

                if (thisLine.substring(0, 8).replaceAll(" ", "").equals(String.valueOf(id))) {
                    continue;
                }
                lines.add(thisLine);
            }

            this.clearWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (int i = 0; i < lines.size(); i++) {
                clearWriter.write(lines.get(i));
                if (i != lines.size()-1) {
                    clearWriter.newLine();
                }
            }
        }

        public void close() throws IOException {
            this.reader.close();
            this.clearWriter.close();
            this.writer.close();
        }

    }
}
