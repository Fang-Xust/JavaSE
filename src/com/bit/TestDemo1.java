package com.bit;
import com.src.demo1.Animal;
/*
 * @Program:untitled4
 * @Description:description
 * @Author:Pufang
 * @Time:2019-11-09 14-55-59
 **/

public class TestDemo1 extends Animal {
    public TestDemo1(String name, int age) {
        super(name, age);
    }

    public void func() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {

       /* Animal animal = new Animal("caocao",10);
        System.out.println(animal.name);*/
        TestDemo1 testDemo1 = new TestDemo1("caocao",10);
        System.out.println(testDemo1.name);
    }

    public static void main1(String[] args) {
        System.out.println("hello");
        //java.util.Date date = new  java.util.Date();
        //int[] array = {1,2,3,4};
        //System.out.println(Arrays.toString(array));
        //System.out.println(date.getTime());
    }
}
