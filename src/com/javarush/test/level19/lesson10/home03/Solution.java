package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        int day, month, year;
        while (file.ready())
        {
            String[] s = file.readLine().split(" ");
            String name = new String();
            year = Integer.parseInt(s[s.length - 1]);
            month = Integer.parseInt(s[s.length - 2]);
            day = Integer.parseInt(s[s.length - 3]);
            Calendar calendar = new GregorianCalendar(year, month - 1, day);
            for (int i = 0; i < s.length - 3; i++)
            {
                name += s[i] + " ";
            }
            PEOPLE.add(new Person(name.trim(), calendar.getTime()));
        }
        for (Person list : PEOPLE)
        {
            System.out.println(list.getName() + " " + list.getBirthday());
        }
        file.close();
    }
}
