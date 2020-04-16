import java.util.*;
import java.util.Scanner;
public class day15Main {
    public int addAB(int A, int B) {
        if(A == 0)
            return B;
        if(B == 0)
            return A;
        return addAB(A ^ B, (A & B) << 1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int count = 0;
            while(x != 0 && count <= 300000){
                x = (x * 2 + 1) % 1000000007;
                count++;
            }
            int ret = (count + 2) / 3;
            System.out.println(ret > 100000 ? -1 : ret);
        }
    }
}


