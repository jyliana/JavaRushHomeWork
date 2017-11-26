package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Василий");
        map.put("Петрова", "Анастасия");
        map.put("Лапин", "Виктор");
        map.put("Ивановская", "Татьяна");
        map.put("Петровская", "Анжела");
        map.put("Смитс", "Джон");
        map.put("Смити", "Джейн");
        map.put("Смит", "Джейк");
        map.put("Чубов", "Алла");
        map.put("Чуб", "Анжела");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (String value : copy.values())
            if (Collections.frequency(copy.values(), value) > 1)
                removeItemFromMapByValue(map, value);
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
