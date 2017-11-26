package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader name1 = new FileReader(reader.readLine());
        FileWriter name2 = new FileWriter(reader.readLine());
        reader.close();
        int count = 0;
        while (name1.ready())
        {
            int data = name1.read();
            if (count % 2 != 0)
                name2.write(data);
            count++;
        }
        name1.close();
        name2.close();
    }
}
