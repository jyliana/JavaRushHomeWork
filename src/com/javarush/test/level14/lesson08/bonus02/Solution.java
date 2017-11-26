package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int nod = 1;
        int min = a;
        int max = b;
        if (a > b)
        {
            min = b;
            max = a;
        }
        for (int i = 1; i < min + 1; i++)
        {
            if ((max % i == 0) && (min % i == 0))
            {
                nod = i;
            }
        }
        System.out.println(nod);
    }
}
