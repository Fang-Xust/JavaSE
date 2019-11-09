
package com.bit;/*
/*
 * @Program:untitled4
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-09 17-33-44
 **/
class Address {
    public String domic;
    public int floor;

    public Address(String domic,int floor) {
        this.domic = domic;
        this.floor = floor;
    }
   /* @Override
    public String toString() {
        return "Address{" +
                "domic='" + domic + '\'' +
                ", floor=" + floor +
                '}';
    }*/
}

class Student{
    public String name;
    public int age;
    public Address address;//组合

    public Student(String name, int age,
                   Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address:domic=" + address.domic +
                ", address:floor=" + address.floor +
                '}';
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Address address = new Address("7",1);
        Student student = new Student
                ("李烨",18,address);
        System.out.println(student);

    }
}

