package com.javarush.test.level14.lesson08.bonus01;

import java.io.CharConversionException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;


/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            for (int i = 0; i < 4; i++)
            {
                int[] arr = new int[2];
                System.out.println(arr[4]);
            }

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            byte[] buffer = new byte[128];
            FileInputStream fis = new FileInputStream("file.txt");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            String m = s.toLowerCase();
            System.out.println(m);
        }
        catch (NullPointerException e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);
            System.out.println(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new URISyntaxException("1", "2");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IOException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new FileSystemException("");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new CharConversionException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new StringIndexOutOfBoundsException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}

