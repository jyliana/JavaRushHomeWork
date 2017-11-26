package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        while (a <= 0)
        {
            a = Integer.parseInt(reader.readLine());
        }
        int maximum;
        int number = Integer.parseInt(reader.readLine());
        maximum = number;
        for (int i = 1; i < a; i++)
        {
            number = Integer.parseInt(reader.readLine());
            if (number > maximum)
                maximum = number;
        }
        System.out.println(maximum);
    }
}
