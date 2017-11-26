package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так,
чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {

        Human grandfather1 = new Human("Петр", true, 78);
        Human grandfather2 = new Human("Остап", true, 85);
        Human grandmother1 = new Human("Дарина", false, 75);
        Human grandmother2 = new Human("Оксана", false, 75);
        Human father = new Human("Богдан", true, 45, grandfather1, grandmother1);
        Human mother = new Human("Агриппина", false, 38, grandfather2, grandmother2);
        Human child1 = new Human("Руслан", false, 18, father, mother);
        Human child2 = new Human("Мария", true, 10, father, mother);
        Human child3 = new Human("Ирина", true, 15, father, mother);

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public Human mother;
        public Human father;

        Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}
