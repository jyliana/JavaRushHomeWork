package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try
        {
            name = reader.readLine();

            InputStream inStream = new FileInputStream(name);
            BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)));

            while (true)
            {
                String line = reader.readLine();
                outStream.write(line + "\r\n");
                if (line.equals("exit"))
                {
                    break;
                }
            }
            inStream.close();
            outStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File does not exist: "+"\n" + e);
        }
    }
}
