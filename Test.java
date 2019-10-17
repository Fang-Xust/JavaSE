/*
* @Program:
* @Description:description
* @Author:Pufang
* @Time:2019/10/9 20:07
**/
public class Test {
    public static int max(int a,int b,int c){
        int max = a >= b ? a : b;
        max = max >= c ? max : c;
        return max;
    }
    public static int[] swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
        return new int[] {a , b};
    }
    public static int sum(){
        int num = 1;
        int sum = 0;
        int ret = 1;
        int j = 1;
        while(num <= 5){
            while(j <= num){
                ret *= j;
                j++;
            }
            sum += ret;
            num++;
        }
        return sum;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 5;
        int[] swap = swap(a,b);
        a = swap[0];
        b = swap[1];
        System.out.println(max(a,b,c));
        System.out.println(a);
        System.out.println(sum());
    }
}
