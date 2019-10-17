/*
* @Program:
* @Description:递归练习
* @Author:Pufang
* @Time:2019/10/14 16:36
**/
public class Recursive {
    public static int fibonacci(int n){     //斐波那契数列循环实现
        int fib1 = 1;
        int fib2 = 1;
        int ret = 0;
        if(n > 0 || n < 3){
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            ret = fib1 + fib2;
            fib1 = fib2;
            fib2 = ret;
        }
        return ret;
    }
    public static int fib(int n){//斐波那契递归求第N个数，效率低
        if(n == 1 || n == 2){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static int sum1(int num){//写一个递归方法，输入一个非负整数，返回组成它的数字之和
        if(num < 10){
            return num;
        }
        return num % 10 + sum1(num / 10);
    }
    public static void print(int n){//按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)

        if(n > 9){
            print(n / 10);
        }
        System.out.println(n % 10);
    }
    public static int factor(int number){//n的阶乘
        if(number == 1){
            return 1;
        }
        return number * factor(number - 1);
    }
    public static int sum(int num){//1 + 2 + 3 + 4 + 5 。。。
        if(num == 1){
            return 1;
        }
        return num + sum(num - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factor(n));
        System.out.println(sum(n));
        print(1234);
        System.out.println(fibonacci(6));
    }
}
