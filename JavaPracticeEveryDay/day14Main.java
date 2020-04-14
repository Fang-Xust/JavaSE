import java.util.Scanner;

public class day14Main {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {//获取到10个计数的输入
            array[i] = sc.nextInt();
        }
        for (int j = 1; j < 10; j++) {//从第2个计数位开始
            if(array[j] != 0){        //如果不为0，就输出第一位，保证它是第一个出现的最小数，
                System.out.print(j);
                array[j]--;             //然后计数再减1，结束循环
                break;
            }
        }
        for (int k = 0; k < 10; k++) {//最后再全部输出，其中已经不包括第一位的数
            while(array[k] != 0){
                System.out.print(k);
                array[k]--;
            }
        }
    }
    public static String GetSequeOddNum(int m){
        int num = m * m * m;
        int avg = num / m;
        int count = m / 2;
        String s = "";
        if(avg % 2 == 0){
            avg--;
            count--;
            while(count != 0){
                avg -= 2;
                count--;
            }
            int begin = avg;
            for (int i = 0; i < m; i++) {
                s += String.valueOf(begin);
                begin += 2;
                if(i != m -1){
                    s += "+";
                }else{
                    continue;
                }
            }
        }else{
            while(count != 0){
                avg -= 2;
                count--;
            }
            int begin = avg;
            for (int i = 0; i < m; i++) {
                s += String.valueOf(begin);
                begin += 2;
                if(i != m -1){
                    s += "+";
                }else{
                    continue;
                }
            }
        }
        return s;
    }

    public static void main02(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(GetSequeOddNum(sc.nextInt()));
        }
    }

    public static void main(String[] args) {//这段代码有问题
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int begin = m * m + 1 - m;
        for (int i = 0; i < m; i++, begin += 2) {
            if(i != m - 1){
                System.out.print(begin + "+");
            }else{
                System.out.print(begin);
            }
        }
    }
}
