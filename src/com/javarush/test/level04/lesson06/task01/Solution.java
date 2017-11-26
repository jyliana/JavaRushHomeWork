package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String int1 = reader.readLine();
        String int2 = reader.readLine();
        int n1=Integer.parseInt(int1);
        int n2=Integer.parseInt(int2);
        if(n1<n2){
            System.out.println(n1);
        }
        else
            System.out.println(n2);

    }
}