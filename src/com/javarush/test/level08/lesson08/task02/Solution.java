package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(23);
        set.add(32);
        set.add(1);
        set.add(4);
        set.add(9);
        set.add(10);
        set.add(-22);
        set.add(-21);
        set.add(-54);
        set.add(129);
        set.add(352);
        set.add(12);
        set.add(8);
        set.add(3);
        set.add(38);
        set.add(44);
        set.add(5);
        set.add(7);
        set.add(87);
        set.add(2);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(
            HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i > 10)
                iterator.remove();
        }
        return set;
    }
}
