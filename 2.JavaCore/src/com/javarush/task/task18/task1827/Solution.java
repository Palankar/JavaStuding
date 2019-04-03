package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileAnalyser analyser = new FileAnalyser(fileName);
        reader.close();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

        if (args.length == 4) {
            switch (args[0]) {
                case "-c":
                    fileWriter.write("\n" + new Line(args[1], args[2], args[3], analyser.maxId()+1).getLine());
            }
        }

        fileWriter.close();
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
        String fileName;
        BufferedReader reader;

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
            reader.close();

            return count;
        }
        
        public int maxId() throws IOException {
            int thisId;
            int maxId = Integer.MIN_VALUE;

            while (reader.ready()) {
                thisId = Integer.parseInt(reader.readLine().substring(0, 8).replaceAll(" ", ""));
                if (thisId > maxId) maxId = thisId;
            }
            reader.close();

            return  maxId;
        }
    }
}
