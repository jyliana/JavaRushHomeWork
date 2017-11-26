package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread sthread1 = new SpecialThread();
        SpecialThread sthread2 = new SpecialThread();
        SpecialThread sthread3 = new SpecialThread();
        SpecialThread sthread4 = new SpecialThread();
        SpecialThread sthread5 = new SpecialThread();
        Thread thread1 = new Thread(sthread1);
        Thread thread2 = new Thread(sthread2);
        Thread thread3 = new Thread(sthread3);
        Thread thread4 = new Thread(sthread4);
        Thread thread5 = new Thread(sthread5);
        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
