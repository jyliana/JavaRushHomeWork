package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream path1 = new FileInputStream(file1);
        FileInputStream path2 = new FileInputStream(file2);

        byte[] f = new byte[path1.available()];
        path1.read(f);
        byte[] s = new byte[path2.available()];
        path2.read(s);

        FileOutputStream path3 = new FileOutputStream(file1);
        path3.write(s);
        path3.write(f);

        reader.close();
        path1.close();
        path2.close();
        path3.close();
    }
}
