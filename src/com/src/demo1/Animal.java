package com.src.demo1;/*
 * @Program:untitled4
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-09 15-19-21
 **/

public class Animal {
    protected String name;
    private int age;
    static {
        System.out.println("Animal::static{}");
    }
    {
        System.out.println("Animal::instance{}");
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String,int)");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println(this.name+"eat()");
    }

    /*public void sleep() {
        System.out.println("sleep()");
    }*/
}

