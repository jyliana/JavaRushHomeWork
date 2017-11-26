package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution
{
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put((double) 15, "Maria");
        labels.put((double) 25, "Angelica");
        labels.put((double) 35, "Anna");
        labels.put((double) 45, "Ivanna");
        labels.put((double) 55, "Rianna");
    }

    public static void main(String[] args)
    {

        System.out.println(labels);
    }
}
