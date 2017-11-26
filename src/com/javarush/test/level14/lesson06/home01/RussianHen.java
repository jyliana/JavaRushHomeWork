package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Inna on 8/15/15.
 */
public class RussianHen extends Hen
{

    int getCountOfEggsPerMonth()
    {
        return 5;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

