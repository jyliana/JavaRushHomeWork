package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<String> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> cats = new HashMap<String, Cat>();
        for (int i = 0; i < 10; i++)
        {
            String name = "The Cat №" + (i + 1);
            cats.put(name, new Cat(name));
        }
        return cats;
    }

    public static Set<String> convertMapToSet(Map<String, Cat> map)
    {
        Set<String> catname = new HashSet<String>();
        for (Map.Entry<String, Cat> stringCatEntry : map.entrySet())
        {
            String name = stringCatEntry.getKey();
            catname.add(name);
        }
        return catname;
    }

    public static void printCatSet(Set<String> set)
    {
        for (String name : set)
        {
            System.out.println(name);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat " + this.name;
        }
    }


}
