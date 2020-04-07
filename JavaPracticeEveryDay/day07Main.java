import java.util.Scanner;

public class day07Main {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][] array = new int[w][h];
        int count = 0;
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(array[i][j] != -1){
                    count++;
                    if(i + 2 < w){
                        array[i + 2][j] = -1;
                    }
                    if(j + 2 < h){
                        array[i][j + 2] = -1;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = a >= b ? a : b;
        while(max < a * b){
            if(max % a == 0 && max % b == 0){
                break;
            }else{
                max++;
            }
        }
        System.out.println(max);
    }
}
