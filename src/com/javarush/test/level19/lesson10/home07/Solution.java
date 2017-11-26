package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        String out = new String();
        while (file1.ready())
        {
            String line[] = file1.readLine().split(" ");

            for (int i = 0; i < line.length; i++)
            {
                if (line[i].length() > 6)
                    out += line[i] + ",";
            }

        }
        file2.write(out.substring(0, out.length()-1));
        file1.close();
        file2.close();
    }
}
