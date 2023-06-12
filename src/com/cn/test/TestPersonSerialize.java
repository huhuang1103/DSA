package com.cn.test;


import java.io.*;

public class TestPersonSerialize {

    /**
     * 序列化
     * @throws IOException
     */
    private static void serializePerson() throws IOException {
        Person person = new Person();
        person.setName("小明");
        person.setAge(23);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\person.txt"));
        objectOutputStream.writeObject(person);
        System.out.println("序列化成功！");
        objectOutputStream.close();
    }

    private static Person deserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\person.txt"));
        Person o = (Person) objectInputStream.readObject();
        System.out.println("反序列化成功");
        return o;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializePerson();
        Person person = deserializePerson();
        System.out.println("person 's name and age:"+person.getName()+","+person.getAge());
    }
}
