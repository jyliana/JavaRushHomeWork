package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("Лето");
        set.add("Лень");
        set.add("Лентяй");
        set.add("Лежать");
        set.add("Лить");
        set.add("Лузгать");
        set.add("Лыко");
        set.add("Лекарства");
        set.add("Лекарь");
        set.add("Ложь");
        set.add("Лгать");
        set.add("Ломать");
        set.add("Лечить");
        set.add("Линять");
        set.add("Лилия");
        set.add("Лиловый");
        set.add("Любовь");
        set.add("Любоваться");
        set.add("Летний");
        set.add("Луковый");
        return set;
    }
}
