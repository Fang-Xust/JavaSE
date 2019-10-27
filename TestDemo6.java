class MyValue{
    public int num;
}
public class TestDemo6 {
    public static void swap(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap1(MyValue myValue1,MyValue myValue2){
        int tmp = myValue1.num;
        myValue1.num = myValue2.num;
        myValue2.num = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.num = 20;
        MyValue myValue2 = new MyValue();
        myValue2.num = 10;
        swap1(myValue1,myValue2);
        System.out.println(myValue1.num + " " + myValue2.num);
}

//    public static void main(String[] args) {//传统方法交换不了
//            int a = 20;
//            int b = 10;
//        System.out.println(a + " " + b);
//        swap(a,b);
//        System.out.println(a + " " + b);
//    }
}
