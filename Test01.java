import java.util.Scanner;
/*
 * @Program:
 * @Description:Homework
 * @Author:Pufang
 * @Time:2019/10/9 20:25
 **/
public class Test01 {
    public static void print_Num(int num){
        int count = 0;
        int[] arr = new int[32];
        int i = 0;
        while(num != 0){
            arr[i++] = num % 2;
            num /= 2;
            count++;
        }
        System.out.println("奇数序列：");
        for(i = count;i >= 0;i -= 2){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("偶数序列：");
        for (i = count - 1;i >= 0;i -= 2){
            System.out.print(arr[i] + " ");
        }
    }
    public static int countBits1(int num){
        int count = 0;
        while(num != 0){
            if(num % 2 == 1){
                count++;
            }
            num /= 2;
        }
        return count;
    }
    public static void password(){
        for(int i = 0;i < 3;i++){
            System.out.println("请输入密码:");
            Scanner in = new Scanner(System.in);
            String password = in.next();
            if(password.equals("123456")){
                System.out.println("登陆成功");
                break;
            }else{
                System.out.println("密码错误，重新输入：");
            }
        }
    }
    public static void intPerBit(){
        int i = 2147234;
        while(i != 0){
            System.out.print((i % 10) + ",");
            i /= 10;
        }
        System.out.println();
    }
    public static void shuixianhuaNumber(){
        int i,j,k,r;
        for(i = 100;i < 1000;i++){
            r = i % 10;
            k = (i / 10) % 10;
            j = i / 100;
            if(Math.pow(j , 3)+Math.pow(k , 3) + Math.pow(r , 3) == i){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void numberNine(){
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if(i / 10 == 9){// 90、91、92.....99
                count++;
            }
            if(i % 10 == 9){// 9、19、29......89、99
                count++;
            }
        }
        System.out.println("1-100之间数字9出现的次数:" + (count - 1));
    }
    public static double sum2(){
        double sum = 0;
        for(double i = 1.0; i <= 100; i++){
            if(i % 2 != 0){
                sum += 1.0 / i;
            }else if(i % 2 == 0){
                sum -= 1.0 / i;
            }
        }
        return sum;
    }
    public static int gcd(int m, int n){
        if(m == n){
            return m;
        }
        while(m != n){
            if(m > n){
                m = m - n;
            }else{
                n = n - m;
            }
        }
        return m;
    }
    public static void printmultiplicationTable(){
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + (i * j) + " ");
            }
            System.out.println();
        }
    }
    public static void leapYear(){
        for(int i = 0; i <= 3000; i++){
            if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)){
                System.out.println(i + " ");
            }
        }
    }
    public static void printPrime(){
        int j;
        for(int i = 100; i <= 200; i++){
            for(j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    break;
                }
            }
            if(j > Math.sqrt(i)) {
                System.out.println(i + " ");
            }
        }
    }
    public static boolean isPrime(int num){
        if(num >= 3){
            return num > 1;
        }
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void age(int age){
        if(age > 0 && age < 18){
            System.out.println("少年");
        }else if(age >= 19 && age <= 28){
            System.out.println("青年");
        }else if(age >= 29 && age <= 55){
            System.out.println("中年");
        }else{
            System.out.println("老年");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入年龄：");
        int num  = in.nextInt();
        age(num);//判断年龄
        System.out.println(isPrime(num));//判断num是否是素数
        printPrime();//打印100-200之间的素数
        leapYear();//打印3000年之内的所有闰年
        printmultiplicationTable();//打印乘法口诀表
        System.out.println(gcd(12,5));//更相减损法求两数最大公约数
        System.out.println(sum2());//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        numberNine();//1-100之间数字9出现的次数
        shuixianhuaNumber();//水仙花数
        intPerBit();//整数的每一位
        password();//密码登陆模拟
        System.out.println("二进制中1的个数：" + countBits1(10));
        print_Num(15);//分别输出一个数中的二进制奇数位和偶数位
    }
}
