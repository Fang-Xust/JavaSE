import java.util.Scanner;

public class day04Main {
    public static int buyApple(int num){
        if(num < 6 || num == 10 || num % 2 != 0){
            return -1;
        }else if(num % 8 == 0){
            return num / 8;
        }
        return (num / 8) + 1;
    }
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(buyApple(num));
        }
    }

    public static String replace(String s1, String s2){
        for(int i = 0; i < s2.length(); i++){
            s1 = s1.replaceAll(s2.substring(i, i + 1), "");
        }
        return s1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(replace(a, b));
    }
}
