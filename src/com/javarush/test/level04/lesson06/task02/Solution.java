package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        String int3 = reader.readLine();
        String int4 = reader.readLine();
        int n1=Integer.parseInt(int1);
        int n2=Integer.parseInt(int2);
        int n3=Integer.parseInt(int3);
        int n4=Integer.parseInt(int4);
        if(max(n1, n2)>max(n3, n4))
            System.out.println(max(n1, n2));
        else
            System.out.println(max(n3, n4));
    }
    public static int max(int a, int b){
        return Math.max(a, b);
    }
}
