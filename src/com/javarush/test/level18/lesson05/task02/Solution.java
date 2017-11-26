package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(file.readLine());
        int counter = 0;

        while (input.available() > 0)
        {
            if (input.read() == 44)
                counter++;
        }
        System.out.println(counter);

        file.close();
        input.close();
    }
}
