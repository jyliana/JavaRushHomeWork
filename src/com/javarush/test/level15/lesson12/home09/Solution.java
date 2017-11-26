package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        Obj(url);
    }

    public static void Obj(String url)
    {
        String small_url = url.substring(url.indexOf("?") + 1, url.length());
        List<String> list = Arrays.asList(small_url.split("&"));
        String outpath = "";
        for (String i : list)
        {
            if (i.contains("="))
            {
                outpath += (i.substring(0, i.indexOf("=")) + " ");
            } else outpath += i + " ";
        }
        System.out.println(outpath.trim());
        for (String i : list)
        {
            if (i.substring(0, 3).equals("obj"))
            {
                try
                {
                    alert(Double.parseDouble(i.substring(4)));
                }
                catch (Exception e)
                {
                    alert(i.substring(4));
                }
            }
        }
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
