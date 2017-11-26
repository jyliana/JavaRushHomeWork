package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader name1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter name2 = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        while (name1.ready())
        {
            name2.write(name1.readLine().replaceAll("\\p{Punct}", ""));
        }
        name1.close();
        name2.close();
    }
}
