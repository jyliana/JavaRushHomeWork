package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    String name;
    String sex;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();

        if (args.length > 0)
        {
            if (args[0].equals("-c"))
            {
                solution.add(args);
            } else if (args[0].equals("-u"))
            {
                solution.update(args);
            } else if (args[0].equals("-d"))
            {
                solution.delete(args);
            } else if (args[0].equals("-i"))
            {
                solution.info(args);
            }
        }
    }

    public void update(String[] args) throws ParseException
    {
        synchronized (allPeople)
        {
            for (int i = 1; i < args.length; i += 4)
            {
                name = args[i + 1];
                sex = args[i + 2];
                String data = args[i + 3];
                allPeople.get(Integer.parseInt(args[i])).setName(name);
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(format.parse(data));
                if (sex.equals("м"))
                    allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                else
                    allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
            }
        }
    }

    public void delete(String[] args) throws ParseException
    {
        synchronized (allPeople)
        {
            for (int i = 1; i < args.length; i++)
            {
                allPeople.get(Integer.parseInt(args[i])).setName("");
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
            }
        }
    }

    public void info(String[] args) throws ParseException
    {
        synchronized (allPeople)
        {
            for (int i = 1; i < args.length; i++)
            {
                if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE))
                    System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + "м" + " " + sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                else
                    System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + "ж" + " " + sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
            }
        }
    }

    public void add(String[] args) throws ParseException
    {
        synchronized (allPeople)
        {
            for (int i = 1; i < args.length; i += 3)
            {
                name = args[i];
                sex = args[i + 1];
                String data = args[i + 2];
                if (sex.equals("м"))
                    allPeople.add(Person.createMale(name, format.parse(data)));
                else
                    allPeople.add(Person.createFemale(name, format.parse(data)));
                System.out.println(allPeople.size() - 1);
            }
        }
    }
}