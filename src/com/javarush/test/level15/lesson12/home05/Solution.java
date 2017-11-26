package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution(int a){}
    public Solution(short a){}
    public Solution(long a){}

    private Solution(Integer a){}
    private Solution(Character a){}
    private Solution(char a){}


    protected Solution(Double a){}
    protected Solution(Short a){}
    protected Solution(Long a){}

    Solution(double a){}
    Solution(float a){}
    Solution(byte a){}
}

