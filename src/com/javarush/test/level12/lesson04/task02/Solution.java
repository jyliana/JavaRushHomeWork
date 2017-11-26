package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(print(5));
        System.out.println(print(4));

    }

    public static Integer print(Integer b)
    {
        return b + b;
    }

    public static String print(int a)
    {
        return "Hi" + a;
    }
}
