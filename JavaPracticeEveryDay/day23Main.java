import java.text.DecimalFormat;
import java.util.Scanner;
//class TreeNode{
//    int val;
//    TreeNode left = null;
//    TreeNode right = null;
//    public TreeNode(int val){
//        this.val = val;
//    }
//}
public class day23Main{
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalance(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isBalance(root.left)){
            return false;
        }
        if(!isBalance(root.right)){
            return false;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int diff = left - right;
        if(diff >= -1 && diff <= 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A1 = 0, A2 = 0, A3 = 0, A5 = 0;
        double A4 = 0;
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int flag = 1;
            int flagA2 = 0;
            int count = 0;
            int max = 0;
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
                if(arr[i] % 5 == 0 && arr[i] % 2 == 0){
                    A1 += arr[i];
                }else if(arr[i] % 5 == 1){
                    A2 += arr[i] * flag;
                    flag *= -1;
                    flagA2++;
                }else if(arr[i] % 5 == 2){
                    A3++;
                }else if(arr[i] % 5 == 3){
                    A4 += arr[i];
                    count++;
                }else if(arr[i] % 5 == 4){
                    if(arr[i] > A5){
                        A5 = arr[i];
                    }
                }
            }
            System.out.print((A1 > 0) ? (A1 + " ") : "N ");
            System.out.print((flagA2 != 0) ? (A2 + " ") : "N ");
            System.out.print((A3 > 0) ? (A3 + " ") : "N ");
            System.out.print((A4 > 0) ? (new DecimalFormat("#.0").format((A4 / count)) + " ") : "N ");
            System.out.print((A5 > 0) ? A5: "N");
        }
    }
}