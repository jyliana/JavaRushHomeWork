package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = arr.length - 1; i >= 0; ) {
            for (int j = 0; j < arr2.length; j++) {
                arr2[j] = arr[i];
                i--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}