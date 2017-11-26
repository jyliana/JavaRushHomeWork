package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter{

    /*public static void main(String[] args) throws IOException
    {
        FileConsoleWriter writer = new FileConsoleWriter("2325.txt");
        char[] ch = new char[]{'a','b','c'};
        String str = "String";
        writer.write(str);
        writer.write(555);
        writer.write(ch);
        writer.write(ch,0,1);
        writer.write(str,1,4);
        writer.close();
    }*/

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public String getEncoding()
    {
        return super.getEncoding();
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.println((char)c);
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        super.write(str, off, len);
        System.out.println(str.substring(off,off+len));
    }

    @Override
    public void flush() throws IOException
    {
        super.flush();
    }

    @Override
    public void close() throws IOException
    {
        super.close();
    }
}
