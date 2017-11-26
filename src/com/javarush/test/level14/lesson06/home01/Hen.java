package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Inna on 8/15/15.
 */
public abstract class Hen
{
    abstract int getCountOfEggsPerMonth();

    String getDescription()
    {
        return "Я курица.";
    }
}