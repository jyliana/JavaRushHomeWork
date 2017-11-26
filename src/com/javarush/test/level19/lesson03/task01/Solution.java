package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution
{
    public static void main(String[] args)
    {
        //это пример вывода
        ATable aTable = new ATable()
        {
            @Override
            public String getCurrentUserName()
            {
                return "Amigo";
            }

            @Override
            public String getTableName()
            {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public interface ATable
    {
        String getCurrentUserName();

        String getTableName();
    }

    public interface BTable
    {
        String getHeaderText();
    }

    public static class TableAdapter implements BTable
    {
        private ATable list;

        TableAdapter(ATable list)
        {
            this.list = list;
        }

        @Override
        public String getHeaderText()
        {
            return "[" + this.list.getCurrentUserName() + "] : " + this.list.getTableName();
        }
    }
}