package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Inna on 8/15/15.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 15;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}