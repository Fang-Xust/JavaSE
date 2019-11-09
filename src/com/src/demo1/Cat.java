package com.src.demo1;/*
 * @Program:untitled4
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-09 17-15-58
 **/

public class Cat extends Animal{
    private String sex;
    static{
        System.out.println("Cat::static{}");
    }
    {
        System.out.println("Cat::instance{}");
    }

    public Cat(String name, int age, String sex) {
        super(name, age);//必须放在第一行
        this.sex = sex;
        System.out.println("Cat(String,int,String)");
    }
/*    public void func(){
        super.sleep();
        int a = super.a;
    }*/
}
