package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<String> list2 = new ArrayList<String>();

        for (int i = 0; i < 2; i++)
        {
            list1.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < list1.get(0); i++)
        {
            list2.add(reader.readLine());
        }
        for (int i = 0; i < list1.get(1); i++)
        {
            list2.add(list2.get(0));
            list2.remove(0);
        }

        for (String s : list2)
        {
            System.out.println(s);
        }
    }
}
