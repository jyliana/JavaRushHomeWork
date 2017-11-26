package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    transient private Date currentDate;
    transient private int temperature;
    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(new Solution(4));
        Solution savedObject = new Solution(5);
        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(new FileOutputStream("file.tmp"));
            oos.writeObject(savedObject);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (oos != null) oos.close();
        }
        Solution loadedObject = new Solution(6);
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream("file.tmp"));
            loadedObject = (Solution) ois.readObject();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (ois != null) ois.close();
        }
        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    @Override
    public String toString()
    {
        return this.string;
    }
}
