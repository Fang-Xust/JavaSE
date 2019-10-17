
import	java.util.Scanner;
public class FrogJump {
    public static int frogJump(int n){
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        return frogJump(n - 1) + frogJump(n - 2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入几级台阶：");
        int n = scan.nextInt();
        System.out.println("青蛙共有"+ frogJump(n) + "种跳法");
    }
}
