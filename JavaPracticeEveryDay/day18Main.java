import java.util.Scanner;

public class day18Main {
    public static void main01(String[] args){
        int m1 = 10 * 30;
        int m2 = 0;
        int begin = 1;
        for (int i = 0; i < 30; i++) {
            m2 += begin;
            begin *= 2;
        }
        System.out.println(m1 + " " + m2);
    }

    public static void main02(String[] args) {
        int m1 = 300;
        int m2 = (1 * (1 - (int)Math.pow(2, 30))) / (1 - 2);
        System.out.println(m1 + " " + m2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int n = sc.nextInt();
            int index = 0;
            int max = 0;
            for (int i = 0; i <= s.length() - n; i++) {
                int count = 0;
                for (int j = i; j < i + n; j++) {
                    if(s.charAt(j) == 'G' || s.charAt(j) == 'C'){
                        count++;
                    }
                }
                if(count > max){
                    max = count;
                    index = i;
                }
            }
            System.out.println(s.substring(index, index + n));
        }
    }
}
