import java.util.*;
import java.util.Scanner;
public class day06Main{
    public static void count(int[] array){
        int A = (array[0] + array[2]) / 2;
        int C = (array[3] - array[1]) / 2;
        int B1 = (array[2] - array[0]) / 2;
        int B2 = (array[1] + array[3]) / 2;
        if(B1 != B2){
            System.out.println("No");
        }else{
            System.out.println(A + " " + B1 + " " + C);
        }
    }
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[4];
        for(int i = 0; i < 4; i++){
            arr[i] = sc.nextInt();
        }
        count(arr);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() / 2 - 1));
    }

}
