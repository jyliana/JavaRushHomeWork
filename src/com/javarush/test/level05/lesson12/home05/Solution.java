package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма».
Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        int sum = 0;

        String n1 = "";
        for (;;) {
            n1 = reader.readLine();
            if (n1.equals("сумма")) {
                break;
            }
            int n2 = Integer.parseInt(n1);
            sum += n2;
        }
        System.out.println(sum);
    }
}