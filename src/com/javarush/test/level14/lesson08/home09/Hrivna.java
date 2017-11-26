package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Inna on 8/18/15.
 */
public class Hrivna extends Money
{
    public Hrivna()
    {
        super();
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }

    public double getAmount()
    {
        return 500;
    }
}
