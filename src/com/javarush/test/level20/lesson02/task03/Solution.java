package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        /*OutputStream outputStream = new FileOutputStream(reader.readLine());*/
        try
        {
            load(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        reader.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, "comments");
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties p = new Properties();
        p.load(inputStream);
        for (Map.Entry s : p.entrySet())
        {
            properties.put(s.getKey().toString(), s.getValue().toString());
        }
        inputStream.close();
    }
}
