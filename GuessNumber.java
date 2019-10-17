import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int randNum = random.nextInt(100) + 1;
        int num = 0;
        while(true){
            System.out.println("请输入一个数字：");
            num = scan.nextInt();
            if(num > randNum){
                System.out.println("大了");
            }else if(num < randNum){
                System.out.println("小了");
            }else{
                System.out.println("对了");
                break;
            }
        }
    }
}
