package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution
{

/*    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ClassWithStatic instance = new ClassWithStatic();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("inna.tmp"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("inna.tmp"));
        ClassWithStatic temp = (ClassWithStatic) ois.readObject();
        ois.close();
    }*/

    public static class ClassWithStatic implements Serializable
    {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void serializeStatic(ObjectOutputStream oos) throws IOException
        {
            oos.writeObject(staticString);
        }

        public static void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException
        {
            staticString = (String) ois.readObject();
        }
    }
}
