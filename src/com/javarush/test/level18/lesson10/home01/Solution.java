package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String filename = args[0];
        FileInputStream file = new FileInputStream(filename);
        int count = 0;
        while (file.available() > 0)
        {
            char data = (char) file.read();
            if (String.valueOf(data).matches(("[a-zA-Z]")))
                count++;
        }
        file.close();
        System.out.println(count);
    }
}
