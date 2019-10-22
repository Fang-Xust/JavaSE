class Person{

    public String name;//属性     成员变量  实例成员变量
    public int age;    //在堆里面


    //static 静态成员变量             //在方法区
    public static int count = 10;
    public static final int SIZE = 30;
    //静态成员变量的访问  通过  类名.属性  去访问    如 Person.count;      Person.SIZE
    //不建议用对象的引用去访问



    //实例成员变量的访问  通过对象的引用去访问           //仍然属于对象，在堆里面
    public final int SIZE2 = 20;

    public static void func1(){
        System.out.println("func1");
    }

    //行为       方法   成员方法   实例成员方法
    public void eat(){
        int b = 10;//局部变量    在栈上
        System.out.println("吃饭!");
    }
    public void sleep(){
        System.out.println("睡觉!");
    }
    public void show(){
        System.out.println("name:" + name + " age:" + age);
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        //实例化一个对象
        Person person = new Person();
        person.name = "刘备";
        person.age = 18;
        person.show();
        person.eat();
        person.sleep();

        //成员变量如果没有赋值，那么他的值就是对应默认的0值，数字类型为0，boolean类型为false，引用类型为null

        person.func1();//报警告了，静态成员方法的调用  通过  类名.方法  进行调用

        //通过   类名.方法  进行调用
        Person.func1();//没有警告

        //注：所有被static所修饰的不管是方法  成员  他的调用或者访问  都只需要通过  类名.方法  就可以做到
        //也就是说：所有被static所修饰的不管是方法  成员  都不依赖于对象

        //在静态方法的内部，不能访问非静态的数据成员：原因：
        //静态的方法 不依赖于对象，而非静态的数据成员依赖于对象，所以不能访问。
        //即在static（非static）修饰的方法内，只能访问static（非static）修饰的成员变量


        //为什么main()函数前面要用static修饰？？  如果不是静态的，那么main函数的调用需要对象

    }
}
