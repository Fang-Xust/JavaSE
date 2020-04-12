import java.util.Scanner;

public class day11Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] != 0){
                System.out.println(i + ":" + array[i]);
            }
        }
    }
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length != 0){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < A.length; i++){
                B[i] = B[i - 1] * A[i - 1];
            }
            //计算下三角连乘
            int tmp = 1;
            for(int j = A.length - 2; j >= 0; j--){
                tmp = tmp * A[j + 1];
                B[j] = B[j] * tmp;
            }
        }
        return B;
    }
}
