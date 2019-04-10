package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null, new File("C:\\Users\\palan\\Desktop"));
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user;
            javaRush.users.add(user = new User());
            user.setFirstName("Николай");
            user.setLastName("Захаров");
            user.setBirthDate(new SimpleDateFormat("d/M/y").parse("22/05/1996"));
            user.setCountry(User.Country.RUSSIA);
            user.setMale(true);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            if (javaRush.equals(loadedObject)) {
                loadedObject.load(inputStream);
                for (User thisUser : javaRush.users) {
                    System.out.println(thisUser.getFirstName() + " " +
                            thisUser.getLastName() + " " +
                            thisUser.isMale() + " " +
                            thisUser.getBirthDate() + " " +
                            thisUser.getCountry());
                }
            }
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);

            for (User user : users) {
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(user.isMale() ? "мужской" : "женский");
                writer.println(user.getBirthDate());
                writer.println(user.getCountry().getDisplayName());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            User user;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                users.add(user = new User());
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setMale(reader.readLine().equals("мужской"));
                user.setBirthDate(new SimpleDateFormat("EEE MMMMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(reader.readLine()));
                String country = reader.readLine();
                if (country.substring(country.indexOf(": ")+1).equals("Russia"))
                    user.setCountry(User.Country.RUSSIA);
                else if (country.equals("Ukraine"))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
