package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String c_name = null;
    private int c_weight = 5;
    private int c_age = 3;
    private String c_color = null;
    private String c_address = null;


    public void initialize(String name)
    {
        this.c_name = name;
    }

    public void initialize(String name, int weight, int age)
    {
        this.c_name = name;
        this.c_age = age;
        this.c_weight = weight;
    }

    public void initialize(String name, int age)
    {
        this.c_name = name;
        this.c_age = age;
    }

    public void initialize(int weight, String color)
    {
        this.c_weight = weight;
        this.c_color = color;
    }

    public void initialize(int weight, String color, String address)
    {
        this.c_weight = weight;
        this.c_color = color;
        this.c_address = address;
    }


}
