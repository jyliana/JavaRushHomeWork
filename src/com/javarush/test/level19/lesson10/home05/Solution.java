package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        String out = new String();
        while (file1.ready())
        {
            String[] s = file1.readLine().split(" ");
            for (String i : s)
            {
                if (i.matches(".*\\d.*"))
                    out += i + " ";
            }
        }
        file2.write(out.trim());
        file1.close();
        file2.close();
    }
}
