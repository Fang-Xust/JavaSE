class Person1{
    private String name;
    private int age;


    //一、体现类的封装性，初始化方式 定义私有成员变量 再提供一系列get和set方法
    //   alt + Insert 生成get和set方法              fn + esc

    //二、构造方法     实例化一个对象时---->构造方法
    // 方法名和类名相同
    //    如果在实现类的时候，没有写构造方法，那么编译器会自动生成一个不带有参数的构造方法。
    //    但是：如果你自己写了一个不带有参数的构造方法，编译器将不会为你生成不带有参数的构造方法
    //构造方法也能发生重载

    //一个对象的产生分为两步：1、为对象分配内存  2、调用合适的构造方法（构造方法不止一个）



    //this.成员变量（实例成员变量  非静态）
    //this.成员方法（实例成员方法）
    //this()    可以用来执行无参或有参的构造方法

    //this代表什么？？   代表“当前对象的引用”（在执行构造方法时，已经为对象分配内存了，所以this代表当前对象的引用）
    //                   注意不是当前对象，原因可以看一下构造方法里面的this.xxx



    public String getName() {
        return name;
    }

    public void setName(String name) {  //（在执行构造方法时，已经为对象分配内存了，所以this代表当前对象的引用）
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //二、通过构造方法：方法名和类名相同

}
public class TestDemo3 {
    Person person = new Person();
}
