package com.javarush.test.level07.lesson09.task03;

import java.util.ArrayList;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        for (int i = 0; i < list.size(); )
        {
            list.add(i + 1, "именно");
            i += 2;
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

    }
}
