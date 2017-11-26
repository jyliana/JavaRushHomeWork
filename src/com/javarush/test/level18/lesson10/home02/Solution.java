package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream input = new FileInputStream(args[0]);
        int count = 0;
        int space = 0;
        while (input.available() > 0)
        {
            int data = input.read();
            count++;
            if (data == 32)
                space++;
        }
        double d = (double) space / count * 100;
        d = new BigDecimal(d).setScale(2, RoundingMode.DOWN).doubleValue();
        /*DecimalFormat f = new DecimalFormat("#,##0.00");
        System.out.println(f.format(double_value));*/
        System.out.println(d);
        input.close();
    }
}
