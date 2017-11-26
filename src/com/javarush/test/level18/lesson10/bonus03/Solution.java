package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(name));
        if (args[0].equals("-u") || args[0].equals("-d"))
        {
            while (file.ready())
            {
                list.add(file.readLine());
            }
            file.close();

            BufferedWriter fileWR = new BufferedWriter(new FileWriter(name));

            if (args[0].equals("-d"))
            {
                for (int i = 0; i < list.size(); i++)
                {
                    int y = Integer.valueOf(list.get(i).substring(0, 8).trim());
                    if (y == Integer.valueOf(args[1]))
                        list.remove(i);
                    fileWR.write(list.get(i) + "\n");
                }
                fileWR.close();
            } else if (args[0].equals("-u"))
            {
                for (int i = 0; i < list.size(); i++)
                {
                    int y = Integer.valueOf(list.get(i).substring(0, 8).trim());
                    if (y == Integer.valueOf(args[1]))
                    {
                        list.remove(i);
                        String productName = args[2];
                        for (int j = 3; j < args.length - 2; j++)
                        {
                            productName += " " + args[j];
                        }
                        list.add(i, String.format("%-8.8s%-30.30s%-8.8s%-4.4s", y, productName, args[args.length - 2], args[args.length - 1]));
                    }
                    fileWR.write(list.get(i) + "\n");
                }
                fileWR.close();
            }
        }
    }
}