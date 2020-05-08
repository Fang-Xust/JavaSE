import java.util.Scanner;
public class Main{
    public static boolean isSxs(int n){
        int n2 = n * n;
        while(n2 % 10 == n % 10){
            n2 /= 10;
            n /= 10;
        }
        if(n == 0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(isSxs(n) == true ? "Yes!" : "No!");
        }
    }
}

import java.util.Scanner;
public class Main{
    public static boolean checkKinds(String s){
        if(s.length() <= 8){
            return false;
        }else{
            int lower = 0;
            int upper = 0;
            int number = 0;
            int ch = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= 'a' &&s.charAt(i) <= 'z'){
                    lower = 1;
                }else if(s.charAt(i) >= 'A' &&s.charAt(i) <= 'Z'){
                    upper = 1;
                }else if(s.charAt(i) >= '0' &&s.charAt(i) <= '9'){
                    number = 1;
                }else{
                    ch = 1;
                }
            }
            return (lower + upper + number + ch) >= 3;
        }
    }
    public static boolean checkRepeat(String s){
        for(int i = 0; i < s.length() - 2; i++){
            String newS = s.substring(i, i + 3);
            if(s.substring(i + 1).contains(newS)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println((checkKinds(s) == true && checkRepeat(s) == false) ? "OK" : "NG");
        }
    }
}

import java.util.Scanner;
public class Main{
    public static float fac(int n){
        if(n == 0)
            return 1;
        return n * fac(n - 1);
    }
    public static float count(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }else{
            return (n - 1) * (count(n - 1) + count(n - 2));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            float ret =  count(n) / fac(n) * 100;
            System.out.println(String.format("%.2f", ret) + "%");
        }
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int arr[] = new int[n+1];
                //代表你使用前i个数组组成j的最大组合数
        long dp[][] = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = cin.nextInt();
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        //注意，你的dp[0][0]一定要是1，否则会出错
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}