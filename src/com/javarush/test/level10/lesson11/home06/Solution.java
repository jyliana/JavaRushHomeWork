package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human man1 = new Human("Karl", 25);
        Human man2 = new Human(23, 40, 27);
        Human man3 = new Human(true, 21, 45, 60);
        Human man4 = new Human("Bill");
        Human man5 = new Human("Bogdan", true);
        Human woman1 = new Human("Alissa", 15);
        Human woman2 = new Human(true, 34, "analyst");
        Human woman3 = new Human("Fiona", true, 31, 45, 60, "doctor");
        Human woman4 = new Human("Angelina", "actress");
        Human woman5 = new Human("Kate", false, "actress");

        System.out.println(man1.toString());
        System.out.println(man2.toString());
        System.out.println(man3.toString());
        System.out.println(man4.toString());
        System.out.println(man5.toString());
        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
        System.out.println(woman3.toString());
        System.out.println(woman4.toString());
        System.out.println(woman5.toString());

    }

    public static class Human
    {
        boolean sex;
        int age;
        int weight;
        int height;
        String name;
        String occupation;

        Human(String name)
        {
            this.name = name;
        }

        Human(String name, String occupation)
        {
            this.name = name;
            this.occupation = occupation;
        }

        Human(String name, boolean sex, String occupation)
        {
            this.name = name;
            this.sex = sex;
            this.occupation = occupation;
        }

        Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        Human(boolean sex, int age, String occupation)
        {
            this.occupation = occupation;
            this.age = age;
            this.sex = sex;
        }

        Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, int weight, int height,
              String occupation)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.occupation = occupation;
        }

        Human(boolean sex, int age, int weight, int height)
        {
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        Human(int age, int weight, int height)
        {
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            text += ", вес: " + this.weight;
            text += ", рост: " + this.height;
            text += ", профессия: " + this.occupation;

            return text;
        }
    }
}