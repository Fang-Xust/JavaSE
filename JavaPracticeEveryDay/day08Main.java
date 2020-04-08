import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class day08Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n > 1000){
                n = 999;
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int del = 0;
            while(list.size() > 1){
                del = (del + 2) % list.size();
                list.remove(del);
            }
            System.out.println(list.get(0));
        }
    }
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int k = Integer.parseInt(s[s.length - 1]);
        int[] arr = new int[s.length - 1];
        for (int i = 0; i < s.length - 1; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            System.out.print(i == k - 1 ? arr[i] : arr[i] + " ");
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        while(sc.hasNextInt()){
//            list.add(sc.nextInt());
//        }
//        int n = list.get(list.size() - 1);
//        list.remove(list.size() - 1);
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//    }
}
