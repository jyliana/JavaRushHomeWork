package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        {
            BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream input = new FileInputStream(file.readLine());
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int data;
            int min = 256;
            while (input.available() > 0)
            {
                data = input.read();
                if (map.containsKey(data))
                    map.put(data, map.get(data) + 1);
                else
                    map.put(data, 1);
            }


            for (Map.Entry<Integer, Integer> list : map.entrySet())
            {
                if (list.getValue() < min)
                    min = list.getValue();
            }

            for (Map.Entry<Integer, Integer> list : map.entrySet())
            {
                if (list.getValue().equals(min))
                    System.out.print(list.getKey() + " ");
            }
            file.close();
            input.close();
        }
    }
}