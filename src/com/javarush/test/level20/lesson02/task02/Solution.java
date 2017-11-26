package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivanna");
            user1.setLastName("Florence");
            user1.setBirthDate(new Date(80, 6, 27));
            user1.setMale(false);
            user1.setCountry(User.Country.OTHER);
            User user2 = new User();
            user2.setFirstName("Ivan");
            user2.setLastName("Flanco");
            user2.setBirthDate(new Date(30, 3, 12));
            user2.setMale(true);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            for (User user : users)
            {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(sdf.format(user.getBirthDate()));
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            while (reader.ready())
            {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(sdf.parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                users.add(user);
            }
            reader.close();
        }
    }
}
