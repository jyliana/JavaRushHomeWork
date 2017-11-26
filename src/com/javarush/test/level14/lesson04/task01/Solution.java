package com.javarush.test.level14.lesson04.task01;

/* Building и School
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должны возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool()
    {
        Building ob = new School();
        //измените null на объект класса Building или School
        return ob;
    }

    public static Building getBuilding()
    {
        Building ob = new Building();
        //измените null на объект класса Building или School
        return ob;
    }

    static class School extends Building
    {
        @Override
        public String toString()
        {
            return "School";
        }
    }

    static class Building /*Add your code here*/
    {
        @Override
        public String toString()
        {
            return "Building";
        }
    }
}
