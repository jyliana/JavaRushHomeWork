package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());
        while (file2.available() > 0)
        {
            byte[] buffer = new byte[file2.available()];
            file2.read(buffer);
            file1.write(buffer);
        }
        while (file3.available() > 0)
        {
            byte[] buffer = new byte[file3.available()];
            file1.write(buffer, 0, file3.read(buffer));
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
