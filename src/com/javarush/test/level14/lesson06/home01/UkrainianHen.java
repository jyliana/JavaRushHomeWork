package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Inna on 8/15/15.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 20;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}