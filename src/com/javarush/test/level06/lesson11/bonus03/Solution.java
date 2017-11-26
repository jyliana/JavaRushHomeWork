package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = numbers.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (numbers[j] > numbers[j + 1])
                {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
    }
}
