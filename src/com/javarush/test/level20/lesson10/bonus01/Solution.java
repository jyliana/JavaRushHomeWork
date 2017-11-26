package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static int[][] degree = new int[10][10];

    public static void main(String args[])
    {
        long a = System.currentTimeMillis();

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                degree[i][j] = (int) Math.pow(i, j);
            }
        }
        getNumbers(548839);
        long b = System.currentTimeMillis();
        System.out.println("time seconds " + (b - a) / 1000);
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    public static char[] toArray(int i)
    {
        String number = String.valueOf(i);
        char[] arrays = number.toCharArray();
        return arrays;
    }

    public static int calcSum(char[] c)
    {
        int tmp = 0;
        for (int i = 0; i < c.length; i++)
        {
            tmp += degree[Character.getNumericValue(c[i])][c.length];
        }
        return tmp;
    }

    public static int[] getNumbers(long N)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            if (i < 10)
                list.add(i);
            else if (i > 99)
            {
                int sum = 0;
                char[] arrays = toArray(i);
                int length = arrays.length;
                for (int j = 0; j < length - 2; j++)
                {
                    if (arrays[j] <= arrays[j + 1] && arrays[j + 2] >= arrays[j + 1])
                    {
                        sum = calcSum(arrays);
                    }
                }
                if (sum != 0 && Integer.toString(i).length()==Integer.toString(sum).length() && calcSum(toArray(sum)) == sum )
                {
                    list.add(sum);
                    i = sum;
                }
            }
        }

        int[] result = new int[list.size()];

        for (Integer element : list)
        {
            System.out.println(element);
        }

        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}


