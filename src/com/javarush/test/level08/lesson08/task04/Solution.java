package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Madonna", new Date("JULY 1 1980"));
        map.put("Sher", new Date("MARCH 1 1980"));
        map.put("Lady Gaga", new Date("AUGUST 1 1980"));
        map.put("Biork", new Date("SEPTEMBER 1 1980"));
        map.put("Sharon Stone", new Date("FEBRUARY 1 1980"));
        map.put("Jane Smit", new Date("APRIL 1 1980"));
        map.put("Jennifer Lopes", new Date("APRIL 1 1980"));
        map.put("Angelina Jolie", new Date("JUNE 1 1980"));
        map.put("Bill Klinton", new Date("JULY 1 1980"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date a = pair.getValue();
            if (a.getMonth() > 4 && a.getMonth() < 8)
                iterator.remove();
        }
    }
    public static void main(String[] args) {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
            System.out.println(pair);
    }
}
