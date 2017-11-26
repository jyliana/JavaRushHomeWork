package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet<String>();
        String filename = reader.readLine();
        String newFile = filename.substring(0, filename.indexOf(".part"));
        while (!filename.equals("end"))
        {
            set.add(filename);
            filename = reader.readLine();
        }

        File file = new File(newFile);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream output = new FileOutputStream(newFile, true);

        for (String item : set) {
            FileInputStream stream = new FileInputStream(item);
            while (stream.available() > 0)
            {
                byte[] buffer = new byte[stream.available()];
                stream.read(buffer);
                output.write(buffer);
            }
            stream.close();
        }
        reader.close();
        output.close();
    }
}
