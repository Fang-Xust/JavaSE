import java.util.Scanner;
public class day24Main{
    public static int gcd(int a, int b){
        int c = 0;
        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= a){
                    a += arr[i];
                }else{
                    a += gcd(a, arr[i]);
                }
            }
            System.out.println(a);
        }
    }


    public static int max(int[] array, int left, int right){
        if(left > right){
            right = left ^ right;
            left = left ^ right;
            right = left ^ right;
        }
        int maxNum = 0;//这里我写成了int maxNum = array[left]，越界了,应该写为array[left - 1]或者直接让maxNum = 0；;
        for(int i = left - 1; i < right; i++){
            if(array[i] > maxNum){
                maxNum = array[i];
            }
        }
        return maxNum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < m; i++){
                char c = sc.next().charAt(0);
                int left = sc.nextInt();
                int right = sc.nextInt();
                if(c == 'Q'){
                    System.out.println(max(arr, left, right));
                }else if(c == 'U'){
                    arr[left - 1] = right;
                }
            }
        }
    }
}