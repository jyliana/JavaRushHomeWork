package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        String tmp = "";
        char buff;
        try
        {
            while (file1.available() > 0)
            {
                do
                {
                    buff = (char) file1.read();
                    tmp = tmp + buff;
                }

                while ((byte) buff != 32 && (byte) buff != 13 && file1.available() > 0);

                try
                {
                    double tmp1 = Double.parseDouble(tmp.trim());

                    file2.write((String.valueOf(Math.round(tmp1))).getBytes());
                    if (file1.available() > 0) file2.write(" ".getBytes());
                    tmp = "";
                }
                catch (Exception e)
                {
                }
            }
        }
        finally
        {
            reader.close();
            file1.close();
            file2.close();
        }

    }
}
