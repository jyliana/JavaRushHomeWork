package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit"))
        {
            new ReadThread(fileName).start();
            fileName = reader.readLine();
        }
        reader.close();
/*        for (Map.Entry el : resultMap.entrySet())
            System.out.println(el.getKey() + " " + el.getValue());*/
    }

    public static class ReadThread extends Thread
    {
        public String fileName;

        public ReadThread(String fileName)
        {
            this.fileName = fileName;
        }

        public void run()
        {
            try
            {
                TreeMap<Integer, Integer> max = new TreeMap<Integer, Integer>();
                FileInputStream input = new FileInputStream(fileName);
                int data;
                int count = 0;
                while (input.available() > 0)
                {
                    data = input.read();
                    if (max.containsKey(data))
                        max.put(data, max.get(data) + 1);
                    else
                        max.put(data, 1);
                }
                for (Map.Entry<Integer, Integer> list : max.entrySet())
                {
                    if (list.getValue() > count)
                        count = list.getValue();
                }
                for (Map.Entry<Integer, Integer> list : max.entrySet())
                {
                    if (list.getValue().equals(count))
                        resultMap.put(fileName, list.getKey());
                }
            }
            catch (Exception e)
            {
            }
        }
    }
}
