
import	java.util.Scanner;/*
* @Program:
* @Description:description
* @Author:Pufang
* @Time:2019/10/16 18:45
**/
public class TestDemo1 {

    //调试：
    // 1、打断点
    // 2、点上面的七星瓢虫
    // 3、箭头
    //注释:ctr + /    or   ctr + shift + /
    public static int frog1(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int floor1 = 1;
        int floor2 = 2;
        int ret = 0;
        for(int i = 3;i <= n;i++){
            ret = floor1 + floor2;
            floor1 = floor2;
            floor2 = ret;
        }
        return ret;
    }
    public static int frog(int n){//递归
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return frog(n - 1) + frog(n - 2);
    }
    public static int fibonacci(int n){
        int i = 1;
        int j = 1;
        int ret = 0;
        if(n == 1 || n == 2){
            return 1;
        }
        for(int k = 3;k <= n;k++){
            ret = i + j;
            i = j;
            j = ret;
        }
        return ret;
    }
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static int sum1(int n){
        if(n <= 9){
            return n;
        }
        return n % 10 + sum1(n / 10);
    }
    public static void print(int n){
        if(n >= 10){
            print(n / 10);
        }
        System.out.println(n % 10);
    }
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n + sum(n - 1);
    }
    public static int fac(int n){
        if(n == 1){
            return 1;
        }
        return n * fac(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(fac(5));
        System.out.println(sum(5));
        print(123);
        System.out.println(sum1(123456));
        System.out.println(fibonacci(1));
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入青蛙跳几级台阶：");
        int n = scan.nextInt();
        System.out.println("青蛙共有" + frog(n) + "种跳法");
    }
}
