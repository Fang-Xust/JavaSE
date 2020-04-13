import java.math.BigInteger;
import java.util.Scanner;
public class day13Main{
    public static void main01(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = sc.next().charAt(0);
        int row = n / 2 + n % 2;
        for(int i = 0; i < row; i++){
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == row - 1 || j == n - 1){
                    System.out.print(c);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            BigInteger sum1 = new BigInteger(a);
            BigInteger sum2 = new BigInteger(b);
            BigInteger res = sum1.add(sum2);
            System.out.println(res);
        }

    }
//大数相加：
//    public static String AddLongInteger(String addend, String augend){
//        BigInteger a = new BigInteger("0");
//        BigInteger bigInteger1 = new BigInteger(addend);
//        BigInteger bigInteger2 = new BigInteger(augend);
//        if(bigInteger1.compareTo(a) > 0 && bigInteger2.compareTo(a) > 0){
//            bigInteger1 = bigInteger1.add(bigInteger2);
//            String s = String.valueOf(bigInteger1);
//            return s;
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String addend = sc.nextLine();
//        String augend = sc.nextLine();
//        System.out.println(AddLongInteger(addend, augend));
//    }
}
