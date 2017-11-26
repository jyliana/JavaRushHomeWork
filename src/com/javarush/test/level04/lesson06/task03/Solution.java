package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        int n1=Integer.parseInt(int1);
        int n2=Integer.parseInt(int2);
        int n3=Integer.parseInt(int3);
        if (n1>n2 && n1>n3 &&n2>n3)
            System.out.println(n1 + n2 + n3);
        else if (n1>n2 && n1>n3 &&n3>n2)
            System.out.println(n1 + n3 + n2);
        else if (n2>n1 && n2>n3 &&n1>n3)
            System.out.println(n2 + n1 + n3);
        else if (n2>n1 && n2>n3 &&n3>n1)
            System.out.println(n2 + n3 + n1);
        else if (n3>n1 && n3>n2 &&n1>n2)
            System.out.println(n3 + n1 + n2);
        else if (n3>n1 && n3>n2 &&n2>n1)
            System.out.println(n3 + n2 + n1);
        else
            System.out.println("Strange");

    }
}
