import java.util.Scanner;

public class day10Main {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n0 = 0;
        int n1 = 1;
        while(sc.hasNext()){
            int n = sc.nextInt();
            while(n > n1){
                int tmp = n0;
                n0 = n1;
                n1 = tmp + n0;
            }
            System.out.println((n - n0) < (n1 - n) ? (n - n0) : (n1 - n));
        }
    }

    public int countWays(int x, int y) {
        if(x == 1 || y == 1)
            return 1;
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}
