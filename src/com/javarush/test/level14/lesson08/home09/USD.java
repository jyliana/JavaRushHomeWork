package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Inna on 8/18/15.
 */
public class USD extends Money
{
    public USD()
    {
        super();
    }

    @Override
    public String getCurrencyName()
    {
        return "USD";
    }

    @Override
    public double getAmount()
    {
        return 2000;
    }
}
