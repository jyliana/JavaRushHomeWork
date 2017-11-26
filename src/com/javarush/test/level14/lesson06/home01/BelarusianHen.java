package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Inna on 8/15/15.
 */

public class BelarusianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 10;
    }

    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}