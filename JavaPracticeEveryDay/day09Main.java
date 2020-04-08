import java.util.Scanner;

public class day09Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("");
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i]);
        }
    }
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while((n = n / 5) != 0){
            count += n;
        }
        System.out.println(count);
    }
}
