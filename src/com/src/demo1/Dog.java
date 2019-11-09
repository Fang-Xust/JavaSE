package com.src.demo1;/*
 * @Program:untitled4
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-09 17-21-16
 **/

public class Dog extends Animal{
    private String sex;
    static {
        System.out.println("Dog::static{}");
    }
    {
        System.out.println("Dog::instance{}");
    }

    public Dog(String name,int age,String sex) {
        super(name,age);
        this.sex = sex;
        System.out.println("Dog(String,int,String)");
    }
    public void bark(){
        System.out.println(this.name + "wangwang");
    }
}
