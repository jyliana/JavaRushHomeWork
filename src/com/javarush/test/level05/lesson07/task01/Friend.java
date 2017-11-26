package com.javarush.test.level05.lesson07.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя инициализаторами (тремя методами initialize):
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String f_name = null;
    private int f_age = 0;
    private String f_sex = null;

    public void initialize(String name)
    {
        this.f_name = name;
    }

    public void initialize(String name, int age)
    {
        this.f_name = name;
        this.f_age = age;
    }

    public void initialize(String name, int age, String sex)
    {
        this.f_name = name;
        this.f_age = age;
        this.f_sex = sex;
    }
}

