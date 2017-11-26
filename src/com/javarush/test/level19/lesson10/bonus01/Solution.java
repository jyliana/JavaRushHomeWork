package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedReader file2 = new BufferedReader(new FileReader(args[1]));
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        while (file1.ready())
        {
            list1.add(file1.readLine());
        }
        file1.close();
        while (file2.ready())
        {
            list2.add(file2.readLine());
        }
        file2.close();
        int c1 = 0;
        int c2 = 0;
        while (c1 < list1.size() && c2 < list2.size())
        {
            if (list1.get(c1).equals(list2.get(c2)))
            {

                lines.add(new LineItem(Type.SAME, list1.get(c1)));
                if (c1 == list1.size() - 1 && c2 == list2.size() - 1)
                {
                    c1++;
                    c2++;
                }
                if (c1 < list1.size() - 1)
                    c1++;
                if (c2 < list2.size() - 1)
                    c2++;
            } else
            {
                if (c1 == list1.size() - 1)
                {
                    if (c2 == list2.size() - 1 && list1.get(c1 - 1).equals(list2.get(c2)))
                    {
                        lines.add(new LineItem(Type.REMOVED, list1.get(c1)));
                        c2++;
                    } else if (c2 == list2.size() - 1 && list1.get(c1).equals(list2.get(c2 - 1)))
                    {
                        lines.add(new LineItem(Type.ADDED, list2.get(c2)));
                        c2++;
                    } else if (list1.get(c1).equals(list2.get(c2 + 1)))
                    {
                        lines.add(new LineItem(Type.ADDED, list2.get(c2)));
                        c2++;
                    } else
                    {
                        lines.add(new LineItem(Type.REMOVED, list1.get(c1)));
                        c1++;
                    }
                } else if (c2 == list2.size() - 1)
                {
                    if (list1.get(c1).equals(list2.get(c2 - 1)))
                    {
                        lines.add(new LineItem(Type.ADDED, list2.get(c2)));
                        c2++;
                    } else
                    {
                        lines.add(new LineItem(Type.REMOVED, list1.get(c1)));
                        c1++;
                    }
                } else if (list1.get(c1).equals(list2.get(c2 + 1)))
                {
                    lines.add(new LineItem(Type.ADDED, list2.get(c2)));
                    c2++;
                } else if (list1.get(c1 + 1).equals(list2.get(c2)))
                {
                    lines.add(new LineItem(Type.REMOVED, list1.get(c1)));
                    c1++;
                }
            }
        }

        for (LineItem element : lines)
        {
            System.out.println(element.type + " " + element.line);
        }
    }

    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}