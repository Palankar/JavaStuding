package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;                  //потому что FileOutputStream не являктся сериализуемым
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(this.fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());        //Чтобы корректно переносилось где угодно (на Винде, к примеру)
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\palan\\Desktop\\coffe.txt"));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\palan\\Desktop\\coffe.txt"));

        Solution solution = new Solution("C:\\Users\\palan\\Desktop\\data.txt");
        solution.writeObject("Что-то такое вот");

        outputStream.writeObject(solution);
        outputStream.flush();
        Solution newSolution = (Solution) inputStream.readObject();
        newSolution.writeObject("Конец!");
    }
}
