package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String line = new String();
        String tag = args[0];
        int count = 0;
        int end = 0;

        while (file.ready())
        {
            line += file.readLine();
            if (line.endsWith(tag))
                line += " ";
        }
        for (int i = 0; i < line.length() - tag.length(); i++)
        {
            if (line.substring(i, i + tag.length() + 1).equals("<" + tag))
            {
                count++;
            } else if (count > 0 && line.substring(i, i + tag.length() + 1).equals("/" + tag))
            {
                while (count > 0)
                {
                    if (line.substring(i, i + tag.length() + 1).equals("/" + tag))
                    {
                        count--;
                        end = i + tag.length() + 1;
                    }
                    i++;
                }
                System.out.println(line.substring(line.indexOf("<" + tag), end + 1));
                line = line.substring(line.indexOf("<" + tag) + tag.length(), line.length());
                i = 0;
                count = 0;
            }
        }
        reader.close();
        file.close();
    }
}