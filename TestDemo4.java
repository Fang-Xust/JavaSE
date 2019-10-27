class Person3{
    private String name;
    private int age;

    public static int count = 10;

    //静态代码块->初始化  静态的数据成员
    static {
        count = 9999999;
        System.out.println("static();静态代码块执行优先于实例代码块优先于构造方法");
    }

    public Person3(){
        System.out.println("Person()静态代码块执行优先于实例代码块优先于构造方法");
    }
    //实例代码块优先构造方法执行
    {
        this.name = "caocao";
        this.age = 99;
        System.out.println("instance()静态代码块执行优先于实例代码块优先于构造方法");
    }

    //静态代码块执行优先于实例代码块优先于构造方法
    //静态的只初始化一次

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person()");
    }
}
public class TestDemo4 {
    public static void main(String[] args) {
        Person3 person = new Person3();
    }
}
